<template>
  <div>
		<form>
			<h1>Ingreso de planilla de horarios</h1>
			<input placeholder="Archivo TXT" type="file" id="fileTXT" ref="fileTXT" v-on:change="handleFileTXT()"/>
			<input placeholder="Archivo JSON" type="file" id="fileJSON" ref="fileJSON" v-on:change="handleFileJSON()"/>
			<button v-on:click="send_horarios">Aceptar</button>
			<button v-on:click="calcular">Calcular</button>
		</form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
	data(){
		return{
			fileTXT: '',
			fileJSON: ''
		}
	},
	methods: {
		send_horarios(e){
			e.preventDefault();
			const formData = new FormData();
			formData.append('fileTXT', this.fileTXT);
			formData.append('fileJSON', this.fileJSON);
			axios.post('http://localhost:8080/importar', formData)
					.then(response => {
						console.log(response.status)
					})
					.catch(function (error) {
						console.log(error);
					});
		},
		handleFileTXT(){
			this.fileTXT = this.$refs.fileTXT.files[0];
		},
		handleFileJSON(){
			this.fileJSON = this.$refs.fileJSON.files[0];
		},
		calcular(e){
			e.preventDefault();
			const axiosInstance = axios.create({
				headers: {
					"Access-Control-Allow-Origin": "*"
				}
			});

			axiosInstance.get('http://localhost:8080/calcular/sueldo')
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