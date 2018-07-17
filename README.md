# Servicio Bienes Raices API

## Integrantes
- Laura
- Luis Fernando Moreno Oviedo
- Katherine Mancera Arango

## Overview  
Crea la Api basado en tipo de inmuebles(Casa, Apartamento...), inmuebles y negociacion(compra, venta, arriendo)

## Data
### TipoInmueble
"idTipoInmueble": "tpa123",
"nombre": "Apartamento"
  
"idTipoInmueble": "tpc123",
"nombre": "Casa"
  
"idTipoInmueble": "tpf123",
"nombre": "Finca"
  
"idTipoInmueble": "tpb123",
"nombre": "Bodega"
	
### Inmueble
"idTipoInmueble": "tpa123",
"idInmueble": "ref1234",
"nombre": "Royal Dec",
"direccion": "Avenida Siempreviva 742",
"region": "Antioquia",
"precioMinimo": 1000,
"precioMaximo": 2000,
"telefono": "11111"
		
"idTipoInmueble": "tpc123",
"idInmueble": "ref4567",
"nombre": "Finca la Rosita",
"direccion": "Avenida Siempreviva 743",
"region": "Cordoba",
"precioMinimo": 500,
"precioMaximo": 600,
"telefono": "22222"		

idTipoInmueble": "tpf123",
"idInmueble": "ref8790",
"nombre": "TuCancun",
"direccion": "Avenida Siempreviva 744",
"region": "Cundinamarca",
"precioMinimo": 444,
"precioMaximo": 500,
"telefono": "33333"
				
"idTipoInmueble": "tpb123",
"idInmueble": "ref9874",
"nombre": "Island Caribb",
"direccion": "Avenida Siempreviva 745",
"region": "Antioquia",
"precioMinimo": 4500,
"precioMaximo": 5000,
"telefono": "44444"

### Negocio
"idInmueble": "ref1234",
"idNegocio": "neg111",
"tipoNegocio": "renta",
"valor": 1200

"idInmueble": "ref4567",
"idNegocio": "neg222",
"tipoNegocio": "compra",
"valor": 540

"idInmueble": "ref8790",
"idNegocio": "neg333",
"tipoNegocio": "compra",
"valor": 484

"idInmueble": "ref9874",
"idNegocio": "neg444",
"tipoNegocio": "venta",
"valor": 4700
