package com.example.congresodanp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.congresodanp.ui.theme.CongresoDANPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CongresoDANPTheme {
                // A surface container using the 'background' color from the theme

                val listaCongreso= remember{ mutableStateListOf<Congresista>()}

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()){
                        ScreenCRUD(listaCongreso)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenCRUD(listaCongresista: MutableList<Congresista>) {
    var nombre by remember { mutableStateOf( "" )}
    var tipo by remember { mutableStateOf( "" )}
    var telefono by remember { mutableStateOf( "" )}
    var correo by remember { mutableStateOf( "" )}
    var monto by remember { mutableStateOf( "" )}
    var isEditando by remember { mutableStateOf( false )}
    var textButton by remember { mutableStateOf( "Agregar Congresista" )}

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            Formulario(
                nombre =nombre,
                funNombre = {nombre = it},
                tipo =tipo,
                funTipo ={tipo=it},
                telefono =telefono,
                funTele ={telefono=it},
                correo =correo,
                funCorreo ={correo=it},
                monto =monto,
                funMonto ={monto=it},
                isEditando =isEditando,
                funEditando ={isEditando=false},
                textButton =textButton,
                funTextButton ={textButton=it},
                listaCongresista =listaCongresista,
                funResetCampos={
                    nombre = ""
                    tipo = ""
                    telefono = ""
                    correo = ""
                    monto = ""
                }
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
                ){
                    items(listaCongresista){congresista ->
                        CardCongresista(
                            funNombre={nombre=it},
                            funTipo={tipo=it},
                            funTele={telefono=it},
                            funCorreo ={correo=it},
                            funMonto ={monto=it},
                            funTextButton ={textButton=it},
                            funEditando ={isEditando=false},
                            funBorrar={ borrarCongre(it,listaCongresista)},
                            congresista = congresista
                        )
                    }
                }
            }
        }
    }

}

fun agregarCongresista(nombre:String,tipo:String,telefono:String,correo:String,monto:String, listaCongresista: MutableList<Congresista>){
    listaCongresista.add(Congresista(nombre,tipo,telefono,correo,monto))
}

fun editarCongresista(nombre:String,tipo:String,telefono:String,correo:String,monto:String, listaCongresista: MutableList<Congresista>){
    listaCongresista.forEach{congresista ->
        if (congresista.nombre==nombre){
            congresista.tipo=tipo
            congresista.telefono=telefono
            congresista.correo=correo
            congresista.monto=monto
        }
    }
}

fun borrarCongre(nombre: String, listaCongresista: MutableList<Congresista>){
    listaCongresista.forEach{congresista ->
        if(congresista.nombre==nombre){
            listaCongresista.remove(congresista)
        }
    }
}
