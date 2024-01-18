<template>
  <div>
		<form>
			<h1>Ingreso de Justificativos</h1>
			<input v-model="justificativo.user_rut" placeholder="Rut" type="text" required/>
			<input v-model="justificativo.fecha" placeholder="Fecha" type="fecha" required/>
			<button v-on:click="send_justificativo">Aceptar</button>
		</form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
	data: () => ({
		justificativo: {
			user_rut: null,
			fecha: null
		}
	}),
	methods: {
		send_justificativo(e){
			if (e) {
      	e.preventDefault()
    	}
			console.log(this.justificativo);
			axios.post('http://localhost:8080/justificativo', this.justificativo)
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
