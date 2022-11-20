package correciones;

public class correciones {
	
	/*
	 * Devolución:
	 * 
		1. Entregan un documento con las decisiones de diseño.
		
		UML:
		
		2. Las relaciones no tienen nombre y varias de ellas no tienen la
		cardinalidad (por lo cual se asume 1, lo cual en varios casos es
		incorrecto). 
		
		3. Área en rigor es un círculo, podría entonces llamarse de esta manera
		para aumentar el reúso y poder ser utilizada legiblemente en otras
		aplicaciones. Sí sería que a a ese círculo se lo referencia desde
		Desafía con un atributo llamado “área” porque justamente es el rol que
		el circulo juega para él.
		
		
		4. Buscar nombres a la vez concisos y descriptivos. Ej:
		“estáDentroDeÁrea” simplemente podría renombrarse a “includes”.
		
				a. Lo mismo ocurre en muchos lugares, ej: en Desafío hay muchos
				nombres de mensajes demasiado largos.
		
				b. Proyecto tiene un atributo “nombreDeProyecto”. Debería llamarse
				simplemente “nombre”, ya se sabe que es suyo dado que es su
				atributo.
				
		5. Se modela una única restricción temporal. Deberían ser varias y
		además poder combinarse. (COMPOSITE)    							  -- LO HACEMOS ENTRE TODOS
		
		6. ActividadLúdica extiende de desafío, pero sólo agrega un mensaje.  --> INTERFAZ  -- Agus : Ya lo hice (Verificar)
		Revisar este diseño.
		
		7. Por un lado modelan la Coordenada, y por otro lado modelan el Área
		(que es un Círculo) pero que sin embargo no utiliza la Coordenada para
		representar su centro. Revisar. No están “reusando” su propio modelo,
		lo cual implica duplicaciones de diseño y código.                         --SANTI
		
		
		8. Característica tiene un atributo “latitud” cuyo objetivo no es claro.  --SANTI
		
		9. El Composite de filtros está inmaduro. Faltan atributos en varios filtros y
		las flechas recursivas de conocimiento típicas del patrón. Revisar
		diseño completo.                                                                --TOMI Y LO AYUDAMOS
		
		10. No hace falta modelar la Aplicación Móvil. De hecho, tanto ésta
		como el Usuario conocen proyectos. No tiene sentido este doble
		conocimiento, dado que la app es del usuario.                        --- Agus : Ya lo hice (Verificar)
		
		11.Debajo de algunas subclases se especifica “Nota: Se implementan los
		msj de la calse superclase”. Esto no es válido en UML. Si eso ocurre,
		entonces repetir los mensajes en las subclases (y eliminar esas notas).  
		
		
		12. Usuario tiene un mensaje “getEstrategiaDeRecomentación”, pero no
		tiene el atributo y ninguna flechar llega hasta tal estrategia. Es
		incorrecto pues no se puedeacceder a la misma. Revisar diseño.
		
		
		13. ProgresoDesafío define correctamente el atributo Desafío pero la
		flecha no aparece en el diagrama. Si bien es válido en UML, siempre se
		sugiere que las flechas tan significativas para el modelo se dibujen
		explícitamente en el diagrama.
		
		
		Implementación:
	
		15. Se entregó la implementación pero, como es de esperar, se
		arrastran hasta aquí errores de diseño como los indicados
		anteriormente. Por ejemplo, la hoja del composite hereda una colección
		de filtros, lo cual es incorrecto.
		
		
		Tests:
		16. Se entregaron. Deben ajustarse de acuerdo a la nueva entrega que
		realicen.

	 * 
	 * 
	 * 
	 */
	
	
}
