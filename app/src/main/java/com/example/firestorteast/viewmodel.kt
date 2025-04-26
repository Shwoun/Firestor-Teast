package com.example.firestorteast

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.api.OAuthRequirements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData.asStateFlow()

    val currentUser = auth.currentUser

    fun userLogin(email: String, password: String, navController: NavController) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                task.user?.let { firebaseUser ->
                    // Firestore থেকে ইউজার ডেটা ফেচ করুন
                    db.collection("users").document(auth.currentUser?.uid?:"")
                        .get()
                        .addOnSuccessListener { document ->
                            val user = document.toObject(User::class.java)
                            _userData.value = user
                            navController.navigate("Home")
                        }
                }
            }
            .addOnFailureListener {
                // Handle login failure
            }
    }

    fun createUser(email: String, name: String, password: String, navController: NavController) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = User(
                        email = email,
                        name = name
                        // Don't store password in Firestore
                    )
                    // Fixed document path - using UID instead of email
                    db.collection("users")
                        .document(auth.currentUser?.uid ?: "")
                        .set(user)
                        .addOnSuccessListener {
                            _userData.value = user
                            navController.navigate("Home")
                        }
                        .addOnFailureListener {
                            // Handle Firestore save failure
                        }
                }
            }
            .addOnFailureListener {
                // Handle user creation failure
            }
    }
init {
    readUser()
}

    fun readUser() {
        viewModelScope.launch {
            val uid = auth.currentUser?.uid ?: return@launch
            db.collection("users")
                .document(uid)
                .addSnapshotListener { value, error ->
                    if (error != null) {
                        // Handle error
                        return@addSnapshotListener
                    }
                    _userData.value = value?.toObject(User::class.java)
                }
        }
    }

    fun dataupdata (email: String,name: String){
        val user = hashMapOf(
            "email" to email,
            "name" to name
        )
        db.collection("users")
            .document(auth.currentUser?.uid?:"")
            .set(user)
            .addOnSuccessListener {
                _userData.value = User(email,name)
            }
    }
}

data class User(
    val email: String = "",
    val name: String = ""

)