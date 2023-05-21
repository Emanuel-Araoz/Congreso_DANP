package com.example.congresodanp

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre:String,
    funNombre:(String) -> Unit,
    tipo:String,
    funTipo:(String) -> Unit,
    telefono: String,
    funTele:(String) -> Unit,
    correo:String,
    funCorreo:(String) -> Unit,
    monto:String,
    funMonto:(String) -> Unit,
    isEditando:Boolean,
    funEditando:() -> Unit,
    textButton:String,
    funTextButton:(String) -> Unit,
    listaCongresista: MutableList<Congresista>,
    funResetCampos:() ->Unit
){
    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine=true,
        maxLines=1,
        onValueChange = {funNombre(it)},
        label = { Text(text="Nombre")},
        enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical=8.dp))

    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value = tipo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine=true,
        maxLines=1,
        onValueChange = {funTipo(it)},
        label = { Text(text="Tipo de Sangre")},
    )
    Spacer(modifier = Modifier.padding(vertical=8.dp))

    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine=true,
        maxLines=1,
        onValueChange = {funTele(it)},
        label = { Text(text="Telefono")},
    )
    Spacer(modifier = Modifier.padding(vertical=8.dp))

    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value = correo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine=true,
        maxLines=1,
        onValueChange = {funCorreo(it)},
        label = { Text(text="Correo")},
    )
    Spacer(modifier = Modifier.padding(vertical=8.dp))

    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value = monto,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine=true,
        maxLines=1,
        onValueChange = {funMonto(it)},
        label = { Text(text="Monto Pagado")},
    )
    Spacer(modifier = Modifier.padding(vertical=8.dp))

    Button(

        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if(isEditando){
                editarCongresista(nombre,tipo,telefono,correo,monto,listaCongresista)
                funTextButton("Agregar Congresista")
                funEditando()
            }else{
                agregarCongresista(nombre,tipo,telefono,correo,monto,listaCongresista)
            }
            funResetCampos()
        }

    ) {
        Text(
            color=Color.White,
            text = textButton)
    }
}