package com.example.firestorteast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/*class viewModel: ViewModel() {
    private val database = Firebase.database("https://test-app-colon-default-rtdb.firebaseio.com/")
private val listdata = database.getReference("User")
    private val _read = MutableStateFlow<List<updata>>(emptyList())
    val read : StateFlow<List<updata>> = _read
    val updatalist = mutableListOf<updata>()
init {
    dataread()
}

    fun dataread () {

        listdata.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (Snapshot in snapshot.children){
                    val data = Snapshot.getValue(updata::class.java)
                    data?.let { updatalist.add(it) }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}
data class updata(
    val Username: String="",
    val Email: String="",
    val Password: String=""
)*/
