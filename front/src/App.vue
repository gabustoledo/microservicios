<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
      <nav>
        <RouterLink to="/horario">Horario</RouterLink>
        <RouterLink to="/justificativo">Justificativo</RouterLink>
        <RouterLink to="/horaExtra">Hora Extra</RouterLink>
        <RouterLink to="/sueldo">Sueldos</RouterLink>
      </nav>
  </header>

  <RouterView />
</template>
