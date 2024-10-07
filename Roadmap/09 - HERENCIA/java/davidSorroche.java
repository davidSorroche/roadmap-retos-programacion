public class Ejercicio09_HerenciaYPolimorfismo {

	public static void main(String[] args) {
		
		new ConceptoHerencia().imprimirSonido();
		new ConceptoHerenciaDificultadExtra().crearEmpleados();

	}

}

import sorroche.david.herenciaypolimorfismo.animales.Animal;
import sorroche.david.herenciaypolimorfismo.animales.Gato;
import sorroche.david.herenciaypolimorfismo.animales.Perro;

public class ConceptoHerencia {
	
	public void imprimirSonido() {
		
		Animal animal = new Animal("Kraken", 108);
		Animal perro = new Perro("Bobby", 5);
		Animal gato = new Gato("Dafne", 10);
		
		System.out.printf("Mi perro se llama %s y tiene %d años. El sonido que emite es %s.\n", animal.getNombre(), animal.getEdad(), animal.getSonido());
		System.out.printf("Mi perro se llama %s y tiene %d años. El sonido que emite al ladrar es %s.\n", perro.getNombre(), perro.getEdad(), perro.getSonido());
		System.out.printf("Mi gato se llama %s y tiene %d años. El sonido que emite al maullar es %s.\n", gato.getNombre(), gato.getEdad(), gato.getSonido());
		
	}

}

public class Animal {
	
	private String nombre;
	private int edad;
	
	public Animal(String nombre, int edad) {
		
		this.nombre = nombre;
		this.edad = edad;
		
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public void setEdad(int edad) {
		
		this.edad = edad;
		
	}
	
	public String getNombre() {
		
		return nombre;
		
	}
	
	public String getSonido() {
		
		return "?";
		
	}
	
	public int getEdad() {
		
		return edad;
		
	}

}

public class Gato extends Animal {

	public Gato(String nombre, int edad) {
		
		super(nombre, edad);
		
	}
	
	
	@Override
	public String getSonido() {
		
		return "miau";
		
	}
	
}

public class Perro extends Animal {

	public Perro(String nombre, int edad) {
		
		super(nombre, edad);
		
	}
	
	public String getSonido() {
		
		return "guau";
		
	}
	
}

import sorroche.david.herenciaypolimorfismo.empleados.*;

public class ConceptoHerenciaDificultadExtra {

	public void crearEmpleados() {
		
		new CrearEmpleados().empleados();
		
	}

}

class CrearEmpleados {
	
	private static final String EMPLEADO_PROGRAMADOR = "Programador";
	private static final String EMPLEADO_GERENTE_PROYECTOS = "Gerentes de Proyectos";
	private static final String EMPLEADO_GERENTE = "Gerentes";
	
	public void empleados() {
		
		Programadores programador1 = (Programadores) registrarEmpleado(EMPLEADO_PROGRAMADOR, null);
		Programadores programador2 = (Programadores) registrarEmpleado(EMPLEADO_PROGRAMADOR, "");
		Programadores programador3 = (Programadores) registrarEmpleado(EMPLEADO_PROGRAMADOR, "Susana");
		Programadores programador4 = registrarProgramador("Elena", "");
		Programadores programador5 = registrarProgramador("David", "Java");
		
		GerentesDeProyectos gerenteProyectos1 = (GerentesDeProyectos) registrarEmpleado(EMPLEADO_GERENTE_PROYECTOS, "");
		GerentesDeProyectos gerenteProyectos2 = (GerentesDeProyectos) registrarEmpleado(EMPLEADO_GERENTE_PROYECTOS, "Ismael");
		
		Gerentes gerente1 = (Gerentes) registrarEmpleado(EMPLEADO_GERENTE, null);
		Gerentes gerente2 = (Gerentes) registrarEmpleado(EMPLEADO_GERENTE, "Teresa");
		Gerentes gerente3 = registrarGerente("Alba", -5000);
		Gerentes gerente4 = registrarGerente("Víctor", 1800);
		
		agregarLenguajeProgramacion(programador2, "JavaScript");
		agregarLenguajeProgramacion(programador3, null);
		agregarLenguajeProgramacion(programador3, "Python");
		
		agregarEmpleadoASuCargo(programador5, programador3);
		
		agregarProyecto(gerenteProyectos1, "Software contabilidad.");
		agregarProyecto(gerenteProyectos2, "");
		agregarProyecto(gerenteProyectos2, "TPV empresa en lenguaje Java.");
		
		agregarEmpleadoASuCargo(gerenteProyectos2, programador1);
		agregarEmpleadoASuCargo(gerenteProyectos2, programador5);
		
		agregarPresupuestoProyectos(gerente1, 1250);
		agregarPresupuestoProyectos(gerente2, -5783.22);
		agregarPresupuestoProyectos(gerente2, 5783.22);
		
		agregarEmpleadoASuCargo(gerente2, programador5);
		agregarEmpleadoASuCargo(gerente4, gerenteProyectos2);
		agregarEmpleadoASuCargo(gerente2, gerenteProyectos1);
		agregarEmpleadoASuCargo(gerente2, gerenteProyectos2);
		
		imprimirDatosEmpleados(programador1);
		imprimirDatosEmpleados(programador2);
		imprimirDatosEmpleados(programador3);
		imprimirDatosEmpleados(programador4);
		imprimirDatosEmpleados(programador5);
		
		imprimirDatosEmpleados(gerenteProyectos1);
		imprimirDatosEmpleados(gerenteProyectos2);
		
		imprimirDatosEmpleados(gerente1);
		imprimirDatosEmpleados(gerente2);
		imprimirDatosEmpleados(gerente3);
		imprimirDatosEmpleados(gerente4);
		
	}
	
	private Empleados registrarEmpleado(String tipoEmpleado, String nombre) {
		
		Empleados empleado = null;
		
		try {
			
			if(tipoEmpleado.equals(EMPLEADO_PROGRAMADOR)) empleado = new Programadores(nombre);
				
			else if (tipoEmpleado.equals(EMPLEADO_GERENTE_PROYECTOS)) empleado = new GerentesDeProyectos(nombre);
			
			else empleado = new Gerentes(nombre);
			
			imprimirEmpleadoRegistrado(empleado);
			
		} catch(IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
		return empleado;
		
	}
	
	private void agregarEmpleadoASuCargo(Empleados empleado, Empleados empleadoASuCargo) {
		
		try {
			
			if(empleado != null && empleadoASuCargo != null) {
				
				empleado.setEmpleadosASuCargo(empleadoASuCargo);
				System.out.printf("\n%s trabaja para %s.\n", empleadoASuCargo.getNombre(), empleado.getNombre());
				
			} else System.err.println("\nEl empleado o el empleado a su cargo no existe.");
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
	}
	
	private Programadores registrarProgramador(String nombre, String lenguajeProgramacion) {
		
		Programadores programador = null;
		
		try {
			
			programador = new Programadores(nombre, lenguajeProgramacion);
			imprimirEmpleadoRegistrado(programador);
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
		return programador;
		
	}
	
	private void agregarLenguajeProgramacion(Programadores programador, String lenguajeProgramacion) {
		
		try {
			
			if(programador != null) {
			
				programador.setLenguajeDeProgramacion(lenguajeProgramacion);
				System.out.printf("\n%s trabaja como programador de %s\n", programador.getNombre(), programador.getLenguajeDeProgramacion());
				
			} else System.err.printf("\nNo existe ningún programador para asignarle el lenguaje de programación %s\n", lenguajeProgramacion);
			
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
	}
	
	private void agregarProyecto(GerentesDeProyectos gerenteProyecto, String proyecto) {
		
		try {
			
			if(gerenteProyecto != null) {
				
				gerenteProyecto.setProyecto(proyecto);
				System.out.printf("\nEl proyecto %s se le ha asignado a %s\n", proyecto, gerenteProyecto.getNombre());
				
			} else System.err.printf("\nNo existe ningún gerente de proyectos para asignarle el proyecto: %s\n", proyecto);
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
	}
	
	private Gerentes registrarGerente(String nombre, double presupuestoProyectos) {
		
		Gerentes gerente = null;
		
		try {
			
			gerente = new Gerentes(nombre, presupuestoProyectos);
			imprimirEmpleadoRegistrado(gerente);
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
		return gerente;
		
	}
	
	private void agregarPresupuestoProyectos(Gerentes gerente, double presupuesto) {
		
		try {
			
			if(gerente != null) {
				gerente.setPresupuestoProyecto(presupuesto);
				System.out.printf("\nEl presupuesto para disponible para proyectos es de %.2f€\n", gerente.getPresupuestoProyecto());
				
			} else System.err.println("\nNo se ha asignado ningún gerente para poder confirmar presupuesto.");
			
		} catch (IllegalArgumentException ex) {
			
			imprimirExcepcion(ex);
			
		}
		
	}
	
	private void imprimirDatosEmpleados(Empleados empleado) {
		
		if(empleado != null) {
			
			System.out.printf("\nId. %d - %s, %s ", empleado.getId(), empleado.getNombre(), empleado.getCargo().toLowerCase());
			
			if(empleado instanceof Programadores) {
				
				Programadores programador = (Programadores) empleado;
				
				System.out.printf("(lenguaje %s)", programador.getLenguajeDeProgramacion());
				
			} else if(empleado instanceof GerentesDeProyectos) {
				
				GerentesDeProyectos gerenteProyecto = (GerentesDeProyectos) empleado;
				
				System.out.print("\n\tProyectos asignados: ");
				
				for(String proyecto : gerenteProyecto.getProyecto()) System.out.printf("%s\t", proyecto);
				
				imprimirEmpleadosACargo(empleado);
				
			} else {
				
				Gerentes gerente = (Gerentes) empleado;
				
				System.out.printf("\n\tPresupuesto para proyectos: %.2f€",gerente.getPresupuestoProyecto());
				
				imprimirEmpleadosACargo(empleado);
				
			}
			
			System.out.println();
			
		}
	}
	
	private void imprimirEmpleadosACargo(Empleados empleado) {
		
		System.out.print("\n\tEmpleados a su cargo: ");
		
		for(Empleados empleadoASuCargo : empleado.getEmpleadosASuCargo()) System.out.printf("%s\t", empleadoASuCargo.getNombre());
		
	}
	
	private void imprimirEmpleadoRegistrado(Empleados empleado) {
		
		System.out.printf("\n%s, %s, ha sido registrado.\n", empleado.getNombre(), empleado.getCargo().toLowerCase());
		
	}
	
	private void imprimirExcepcion(Exception ex) {
		
		System.err.printf("\n%s\n", ex.getMessage());
		
	}

}

import java.util.ArrayList;
import java.util.List;

import sorroche.david.herenciaypolimorfismo.EmpleadoNoRegistradoException;

public abstract class Empleados {
	
	private static int idx = 1;
	
	protected final List<Empleados> empleadosASuCargo;
	
	private int id;
	private String nombre;
	
	public Empleados(String nombre) {
		
		validarNombre(nombre);
		
		empleadosASuCargo = new ArrayList<>();
			
		id = idx;
		this.nombre = nombre;
			
		idx++;
		
	}
	
	public abstract void setEmpleadosASuCargo(Empleados empleado);
	
	public int getId() {
		
		return nombre != null && !nombre.isEmpty() ? id : 0;
		
	}
	
	public String getNombre() {
		
		return nombre != null ? nombre : "";
		
	}
	
	public String getCargo() {
		
		return nombre != null && !nombre.isEmpty() ? "Sin determinar" : "";
		
	}
	
	public List<Empleados> getEmpleadosASuCargo() {
		
		return empleadosASuCargo;
		
	}
	
	private void validarNombre(String nombre) {
		
		if(nombre == null || nombre.isEmpty()) throw new EmpleadoNoRegistradoException("empleado");
		
	}

}

import sorroche.david.herenciaypolimorfismo.EmpleadoNoRegistradoException;

public class Programadores extends Empleados {
	
	private static final String CARGO = "Programador";
	
	private String lenguajeDeProgramacion;

	public Programadores(String nombre) {
		
		super(nombre);

	}
	
	public Programadores(String nombre, String lenguajeDeProgramacion) {
		
		this(nombre);
		
		validarLenguajeDeProgramacion(lenguajeDeProgramacion);
		
		this.lenguajeDeProgramacion = lenguajeDeProgramacion;
		
	}
	
	public void setLenguajeDeProgramacion(String lenguajeDeProgramacion) {
		
		validarLenguajeDeProgramacion(lenguajeDeProgramacion);
		
		this.lenguajeDeProgramacion = lenguajeDeProgramacion;
		
	}
	
	@Override
	public void setEmpleadosASuCargo(Empleados empleado) {
		
		throw new IllegalArgumentException("Un programador no puede tener empleados a su cargo.");
		
	}
	
	@Override
	public String getCargo() {
		
		return CARGO;
		
	}
	
	public String getLenguajeDeProgramacion() {
		
		validarLenguajeDeProgramacion(lenguajeDeProgramacion);
		
		return lenguajeDeProgramacion;
		
	}
	
	private void validarLenguajeDeProgramacion(String lenguajeDeProgramacion) {	
		
		if(lenguajeDeProgramacion == null || lenguajeDeProgramacion.isEmpty()) throw new EmpleadoNoRegistradoException("programador");
		
	}

}

import java.util.ArrayList;
import java.util.List;

import sorroche.david.herenciaypolimorfismo.EmpleadoNoRegistradoException;

public class GerentesDeProyectos extends Empleados {
	
	private static final String CARGO = "Gerente de proyectos";
	
	private List<String> listadoProyectos;

	public GerentesDeProyectos(String nombre) {
		
		super(nombre);
		listadoProyectos = new ArrayList<>();
	
	}
	
	@Override
	public void setEmpleadosASuCargo(Empleados empleado) {
		
		if(empleado != null) super.empleadosASuCargo.add(empleado);
		
	}
	
	public void setProyecto(String proyecto) {
		
		validarProyecto(proyecto);
		
		listadoProyectos.add(proyecto);
		
	}
	
	@Override
	public String getCargo() {
		
		return CARGO;
		
	}
	
	public List<String> getProyecto() {
		
		return listadoProyectos;
		
	}
	
	private void validarProyecto(String proyecto) {
		
		if(proyecto == null || proyecto.isEmpty()) throw new EmpleadoNoRegistradoException("gerente de proyectos");
		
	}

}

import sorroche.david.herenciaypolimorfismo.EmpleadoNoRegistradoException;

public class Gerentes extends Empleados {
	
	private static final String CARGO = "Gerente";
	
	private double presupuestoProyecto;

	public Gerentes(String nombre) {
		
		super(nombre);

	}
	
	public Gerentes(String nombre, double presupuestoProyecto) {
		
		this(nombre);
		
		validarPresupuestoProyecto(presupuestoProyecto);
		
		this.presupuestoProyecto = presupuestoProyecto;
		
	}
	
	@Override
	public void setEmpleadosASuCargo(Empleados empleado) {

		if(empleado != null) super.empleadosASuCargo.add(empleado);
		
	}
	
	public void setPresupuestoProyecto(double presupuestoProyecto) {
		
		validarPresupuestoProyecto(presupuestoProyecto);
		
		this.presupuestoProyecto = presupuestoProyecto;
		
	}
	
	@Override
	public String getCargo() {
		
		return CARGO;
		
	}
	
	public double getPresupuestoProyecto() {
		
		validarPresupuestoProyecto(presupuestoProyecto);
		
		return presupuestoProyecto;
		
	}
	
	private void validarPresupuestoProyecto(double presupuestoProyecto) {
		
		if(presupuestoProyecto < 0.0) throw new EmpleadoNoRegistradoException("gerente");
	
	}

}

public class EmpleadoNoRegistradoException extends IllegalArgumentException {
	
	public EmpleadoNoRegistradoException(String tipoEmpleado) {
		
		super("El " + tipoEmpleado + " no ha sido registrado");
		
	}

}
