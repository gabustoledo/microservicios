<template>
  <div>
		<form>
			<h1>Ingreso de Horas Extras</h1>
			<input v-model="hora_extra.user_rut" placeholder="Rut" type="text" required/>
			<input v-model="hora_extra.fecha" placeholder="Fecha" type="fecha" required/>
			<input v-model="hora_extra.cantidad" placeholder="Cantidad" type="fecha" required/>
			<button v-on:click="send_hora_extra">Aceptar</button>
		</form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
	data: () => ({
		hora_extra: {
			user_rut: null,
			fecha: null,
			cantidad: null
		}
	}),
	methods: {
		send_hora_extra(e){
			if (e) {
      	e.preventDefault()
    	}
			console.log(this.hora_extra);
			axios.post('http://localhost:8080/horaExtra', this.hora_extra)
					.then(response => {
						console.log(response.status)
					})
					.catch(function (error) {
						console.log(error);
					});
		}
	}
}
</script>