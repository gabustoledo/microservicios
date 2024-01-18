<template>
  <div>
    <h1>Vista de tabla de sueldo</h1>
  </div>
  <table>
  <thead>
    <tr>
      <th>Rut</th>
      <th>Nombre</th>
      <th>Apelido</th>
      <th>Area</th>
      <th>Categoria</th>
      <th>Tiempo (años)</th>
      <th>Sueldo fijo</th>
      <th>Bono HE</th>
      <th>Bono TS</th>
      <th>Bono P</th>
      <th>Desc Ingr</th>
      <th>Des Sal</th>
      <th>Sueldo Bruto</th>
      <th>Prevision</th>
      <th>Salud</th>
      <th>Sueldo Final</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(sueldo,i) in sueldos" :key="i">
      <td>{{ sueldo.user_rut }}</td>
      <td>{{ sueldo.nombre }}</td>
      <td>{{ sueldo.apellido }}</td>
      <td>{{ sueldo.area }}</td>
      <td>{{ sueldo.categoria }}</td>
      <td>{{ sueldo.tiempoServicio }}</td>
      <td>{{ sueldo.sueldoFijo }}</td>
      <td>{{ sueldo.bonoHorasExtras }}</td>
      <td>{{ sueldo.bonoTiempoServicio }}</td>
      <td>{{ sueldo.bonoPuntualidad }}</td>
      <td>{{ sueldo.descuentoIngreso }}</td>
      <td>{{ sueldo.descuentoSalida }}</td>
      <td>{{ sueldo.sueldoBruto }}</td>
      <td>{{ sueldo.prevision }}</td>
      <td>{{ sueldo.salud }}</td>
      <td>{{ sueldo.sueldoFinal }}</td>
    </tr>
   </tbody>
</table>
</template>

<script>
import axios from 'axios'

export default {
	data: () => ({
		sueldos: {}
	}),
	methods: {
		getSueldos(e){
      const axiosInstance = axios.create({
				headers: {
					"Access-Control-Allow-Origin": "*"
				}
			});
      axiosInstance.get('http://localhost:8080/reporte')
					.then(response => {
						console.log(response.status)
            this.sueldos = response.data;
					})
					.catch(function (error) {
						console.log(error);
					});
		}
	},
  beforeMount(){
    this.getSueldos()
  }
}
</script>