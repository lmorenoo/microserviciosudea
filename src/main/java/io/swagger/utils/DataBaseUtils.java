package io.swagger.utils;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Inmueble;
import io.swagger.model.Negocio;
import io.swagger.model.TipoInmueble;

public class DataBaseUtils {

	private static List<TipoInmueble> tipoInmuebles = new ArrayList<>();
	private static List<Inmueble> inmuebles = new ArrayList<>();
	private static List<Negocio> negocios = new ArrayList<>();

	static {
		TipoInmueble tipoInmueble1 = new TipoInmueble("tpa123", "Apartamento");
		TipoInmueble tipoInmueble2 = new TipoInmueble("tpc123", "Casa");
		TipoInmueble tipoInmueble3 = new TipoInmueble("tpf123", "Finca");
		TipoInmueble tipoInmueble4 = new TipoInmueble("tpb123", "Bodega");
		tipoInmuebles.add(tipoInmueble1);
		tipoInmuebles.add(tipoInmueble2);
		tipoInmuebles.add(tipoInmueble3);
		tipoInmuebles.add(tipoInmueble4);

		Inmueble inmueble1 = new Inmueble("tpa123", "ref1234", "Royal Dec", "Avenida Siempreviva 742", "Antioquia",
				1000, 2000, "11111");
		Inmueble inmueble2 = new Inmueble("tpc123", "ref4567", "Finca la Rosita", "Avenida Siempreviva 743", "Cordoba",
				500, 600, "22222");
		Inmueble inmueble3 = new Inmueble("tpf123", "ref8790", "TuCancun", "Avenida Siempreviva 744", "Cundinamarca",
				444, 500, "33333");
		Inmueble inmueble4 = new Inmueble("tpb123", "ref9874", "Island Caribb", "Avenida Siempreviva 745", "Antioquia",
				4500, 5000, "44444");
		inmuebles.add(inmueble1);
		inmuebles.add(inmueble2);
		inmuebles.add(inmueble3);
		inmuebles.add(inmueble4);

		Negocio negocio1 = new Negocio("neg111", "ref1234", "renta", 1200);
		Negocio negocio2 = new Negocio("neg222", "ref4567", "compra", 540);
		Negocio negocio3 = new Negocio("neg333", "ref8790", "compra", 484);
		Negocio negocio4 = new Negocio("neg444", "ref9874", "venta", 4700);
    Negocio negocio5 = new Negocio("neg888", "ref1234", "renta", 1000);
		negocios.add(negocio1);
		negocios.add(negocio2);
		negocios.add(negocio3);
		negocios.add(negocio4);
    negocios.add(negocio5);
	}

	public static List<TipoInmueble> getTipoInmuebles() {
		removeTipoInmublesLinks();
		return tipoInmuebles;
	}

	public static List<Inmueble> getInmuebles() {
		removeInmueblesLinks();
		return inmuebles;
	}

	public static List<Negocio> getNegocios() {
		removeNegociosLinks();
		return negocios;
	}

	public static boolean crearTipoInmueble(TipoInmueble tipoInmueble) {
		return tipoInmuebles.add(tipoInmueble);
	}

	public static boolean crearInmueble(Inmueble inmueble) {
		return inmuebles.add(inmueble);
	}

	public static boolean crearNegocio(Negocio negocio) {
		return negocios.add(negocio);
	}

	public static boolean removerTipoInmueble(TipoInmueble tipoInmueble) {
		return tipoInmuebles.remove(tipoInmueble);
	}

	public static boolean removerInmueble(Inmueble inmueble) {
		removeInmueblesLinks();
		return inmuebles.remove(inmueble);
	}

	public static boolean removerNegocio(Negocio negocio) {
		removeNegociosLinks();
		return negocios.remove(negocio);
	}

	public static TipoInmueble getTipoInmueble(String idTipoInmueble) {
		removeTipoInmublesLinks();
		return tipoInmuebles.stream().filter(tipoIn -> tipoIn.getIdTipoInmueble().equals(idTipoInmueble)).findFirst()
				.orElse(null);
	}

	public static Inmueble getInmueble(String idInmueble) {
		removeInmueblesLinks();
		return inmuebles.stream().filter(inmueble -> inmueble.getIdInmueble().equals(idInmueble)).findFirst()
				.orElse(null);
	}

	public static Negocio getNegocio(String idNegocio) {
		removeNegociosLinks();
		return negocios.stream().filter(negocio -> negocio.getIdNegocio().equals(idNegocio)).findFirst().orElse(null);
	}

	private static void removeTipoInmublesLinks() {
		tipoInmuebles.forEach(tipoInmueble -> tipoInmueble.removeLinks());
	}

	private static void removeInmueblesLinks() {
		inmuebles.forEach(inmueble -> inmueble.removeLinks());
	}

	private static void removeNegociosLinks() {
		negocios.forEach(negocio -> negocio.removeLinks());
	}

}
