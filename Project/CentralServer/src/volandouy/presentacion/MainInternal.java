package volandouy.presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import volandouy.logica.*;
import volandouy.datatypes.*;
import volandouy.excepciones.SetException;

import java.awt.Font;




public class MainInternal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean datosCargados = false;


	public MainInternal() {
		FechaActual.getInstancia().setFechaActual(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),  LocalDate.now().getYear());

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,  100,  745,  505);
		setResizable(true);
		setSize(screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0,  0, screenSize.width, screenSize.height);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblTitulo = new JLabel("<html><span style='color: #00BFFF;'>Volando</span><span style='color: #FFFF00;'>Uy</span></html>",  SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial",  Font.BOLD,  99));
        lblTitulo.setBounds(396 ,  329,  574,  125);  
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); 
        desktopPane.add(lblTitulo,  JDesktopPane.DEFAULT_LAYER - 1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0,  0, screenSize.width,  22);
		desktopPane.add(menuBar);
		
		JMenu menuUsuario = new JMenu("Usuario");
		menuBar.add(menuUsuario);
		
		JMenu menuRutaDeVuelo = new JMenu("Rutas De Vuelo");
		menuBar.add(menuRutaDeVuelo);
		
		JMenuItem mntmBotonCrearUsuario = new JMenuItem("Crear Usuario");
		mntmBotonCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuarioInternalFrame open = new CrearUsuarioInternalFrame();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuUsuario.add(mntmBotonCrearUsuario);
		
		JMenuItem mntmBotonModificarUsuario = new JMenuItem("Modificar Usuario");
		mntmBotonModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarDatosInternalFrame open = new ModificarDatosInternalFrame();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuUsuario.add(mntmBotonModificarUsuario);
		
		JMenuItem mntmBotonConsultarUsuario = new JMenuItem("Consultar Usuario");
		mntmBotonConsultarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaUsuarioInternalFrame open = new ConsultaUsuarioInternalFrame(desktopPane);
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuUsuario.add(mntmBotonConsultarUsuario);
		
		JMenuItem mntmBotonConsultaRutaDeVuelo = new JMenuItem("Consulta Ruta de Vuelo");
		mntmBotonConsultaRutaDeVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaRutaDeVueloInternal open = new ConsultaRutaDeVueloInternal(desktopPane,  null);
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuRutaDeVuelo.add(mntmBotonConsultaRutaDeVuelo);

		JMenuItem mntmBotonCrearRutaDeVuelo = new JMenuItem("Crear Ruta de Vuelo");
		mntmBotonCrearRutaDeVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearRutaDeVueloInternal open = new CrearRutaDeVueloInternal();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuRutaDeVuelo.add(mntmBotonCrearRutaDeVuelo);
		
		JMenuItem mntmAceptarRuta = new JMenuItem("Aceptar Ruta de Vuelo");
		mntmAceptarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarRutaInternal open = new AceptarRutaInternal();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
				
			}
		});
		menuRutaDeVuelo.add(mntmAceptarRuta);

		JMenu menuCiudades = new JMenu("Ciudades");
		menuBar.add(menuCiudades);
		
		JMenuItem mntmBotonCrearCiudad = new JMenuItem("Crear Ciudad");
		mntmBotonCrearCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCiudadInternalFrame open = new CrearCiudadInternalFrame();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuCiudades.add(mntmBotonCrearCiudad);
		
		JMenu menuPaquete = new JMenu("Paquete");
		menuBar.add(menuPaquete);
		
		JMenuItem mntmBotonCrearPaquete = new JMenuItem("Crear Paquete");
		mntmBotonCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPaqueteDeRutasDeVueloInternal open = new CrearPaqueteDeRutasDeVueloInternal();
				open.setVisible(true);
				desktopPane.add(open);
				open.moveToFront();
				
			}
		});
		menuPaquete.add(mntmBotonCrearPaquete);

		JMenuItem mntmBotonCompraPaquete = new JMenuItem("Comprar paquete");
		mntmBotonCompraPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraPaqueteInternal open = new CompraPaqueteInternal();
				open.setVisible(true);
				desktopPane.add(open);	
				open.toFront();
			}
		});
		menuPaquete.add(mntmBotonCompraPaquete);

		JMenuItem mntmBotonAgregarRutaAPaquete = new JMenuItem("Agregar Ruta a Paquete");
		mntmBotonAgregarRutaAPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarRutaAPaqueteInternal open = new AgregarRutaAPaqueteInternal();
				open.setVisible(true);
				desktopPane.add(open);	
				open.toFront();
			}
		});
		menuPaquete.add(mntmBotonAgregarRutaAPaquete);

		JMenuItem mntmBotonConsultarPaquete = new JMenuItem("Consultar Paquete");
		mntmBotonConsultarPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPaqueteInternal open = new ConsultaPaqueteInternal(desktopPane,  null);
				open.setVisible(true);
				desktopPane.add(open);	
				open.toFront();
			}
		});
		menuPaquete.add(mntmBotonConsultarPaquete);
		
		JMenu menuVuelos = new JMenu("Vuelos");
		menuBar.add(menuVuelos);
		
		JMenuItem mntmBotonCrearVuelo = new JMenuItem("Crear Vuelo");
		mntmBotonCrearVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearVueloInternal open = new CrearVueloInternal();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuVuelos.add(mntmBotonCrearVuelo);
		
		JMenuItem mntmBotonConsultaVuelo = new JMenuItem("Consulta Vuelo");
		mntmBotonConsultaVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVueloInternalFrame open = new ConsultaVueloInternalFrame(null, null);
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuVuelos.add(mntmBotonConsultaVuelo);
		
		JMenuItem mntmBotonReservaVuelo = new JMenuItem("Reservar vuelo");
		mntmBotonReservaVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservaVueloInternalFrame open = new ReservaVueloInternalFrame();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();
			}
		});
		menuVuelos.add(mntmBotonReservaVuelo);

		JMenu menuDatos = new JMenu("Datos");
		menuBar.add(menuDatos);

		JMenuItem mntmBotonCargarDatos = new JMenuItem("Cargar datos");
		mntmBotonCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!datosCargados){
					cargarDatos();
				}
			}
		});
		menuDatos.add(mntmBotonCargarDatos);

		JMenuItem mntmBotonCambiarFecha = new JMenuItem("Cambiar fecha");
		mntmBotonCambiarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DTFecha f = new DTFecha();
				// System.out.println(f.toString());
				// System.out.println("Ingrese fecha:");
				// Scanner scanner = new Scanner(System.in);
				// String[] fecha = scanner.nextLine().split(" ");
				// FechaActual.getInstancia().setFechaActual(Integer.parseInt(fecha[0]),  Integer.parseInt(fecha[1]),  Integer.parseInt(fecha[2]));
				// scanner.close();
				// System.out.println("Fecha ingresada" + fecha[0] + fecha[1] + fecha[2]);
				CambiarFechaInternal open = new CambiarFechaInternal();
				open.setVisible(true);
				desktopPane.add(open);
				open.toFront();


			}
		});
		menuDatos.add(mntmBotonCambiarFecha);
	}

	public void cargarDatos(){

        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

		ManCiudad.getInstancia().agregarPais("Uruguay");
        ManCiudad.getInstancia().agregarPais("Alemania");
        ManCiudad.getInstancia().agregarPais("Panamá");
        ManCiudad.getInstancia().agregarPais("Argentina");
        ManCiudad.getInstancia().agregarPais("España");
        ManCiudad.getInstancia().agregarPais("Chile");
        ManCiudad.getInstancia().agregarPais("Estado Unidos");
        ManCiudad.getInstancia().agregarPais("Brasil");
        ManCiudad.getInstancia().agregarPais("Italia");
        ManCiudad.getInstancia().agregarPais("Mexico");
        ManCiudad.getInstancia().agregarPais("Canada");
        ManCiudad.getInstancia().agregarPais("Francia");
        ManCiudad.getInstancia().agregarPais("Inglaterra");
        ManCiudad.getInstancia().agregarPais("Australia");
        ManCiudad.getInstancia().agregarPais("Nueva Zelanda");
        ManCiudad.getInstancia().agregarPais("Suecia");
        ManCiudad.getInstancia().agregarPais("Dinamarca");
        ManCiudad.getInstancia().agregarPais("Noruega");
        ManCiudad.getInstancia().agregarPais("Finlandia");
        ManCiudad.getInstancia().agregarPais("Colombia");
        ManCiudad.getInstancia().agregarPais("Peru");
        ManCiudad.getInstancia().agregarPais("Venezuela");
        ManCiudad.getInstancia().agregarPais("Ecuador");
        ManCiudad.getInstancia().agregarPais("Paraguay");
        ManCiudad.getInstancia().agregarPais("Bolivia");
		try {
			controladorUsuarios.altaAerolinea("aerolineas", "Aerolíneas Argentinas", "servicioalcliente@aerolineas.com.uy","zaq1xsw2", "Aerolínea nacional de Argentina que ofrece vuelos directos entre múltiples destinos.", "https://www.aerolineas.com.ar");
			controladorUsuarios.altaAerolinea("aireuropa", "Air Europa", "reservas@aireuropa.com.uy","cde3vfr4",  "Aerolínea española que ofrece vuelos a varios destinos en Europa y América.", "https://www.aireuropa.com");
			controladorUsuarios.altaAerolinea("copaair", "Copa Airlines", "contacto@copaair.com.uy","2wsx3edc",  "Aerolínea panameña con conexiones a varios destinos en América y el Caribe.", "https://www.copaair.com");
			controladorUsuarios.altaAerolinea("iberia", "Iberia", "atencionclientes@iberia.com.uy","qwer1234",  "Aerolínea española que te conecta con Europa y otros destinos internacionales.", "https://www.iberia.com");
			controladorUsuarios.altaAerolinea("latam", "LATAM Airlines", "info@latam.com.uy", "mki8nju7", "Ofrecemos vuelos nacionales e internacionales.", "https://www.latam.com");
			controladorUsuarios.altaAerolinea("zfly", "ZuluFly", "info@zfly.com", "r45tgvcf", "Viajes exclusivos entre los destinos más solicitados.", "http://www.zfly.com");

			controladorUsuarios.altaCliente("anarod87", "Ana", "arodriguez87@netuy.com","bgt5nhy6", "Rodríguez",  new DtFecha(18, 02, 1987), "Uruguay", EnumDocumento.PASAPORTE, "B2345678");
			controladorUsuarios.altaCliente("claire93d", "Claire", "claire.db@frmail.fr","mju76yhn", "Rinaldi", new DtFecha(22, 8, 1993), "Italia", EnumDocumento.PASAPORTE, "20VF756483");
			controladorUsuarios.altaCliente("csexto", "Cristian", "csexto@adinet.com.uy","4rfvbgt5", "Sexto",  new DtFecha(26, 03, 1987), "Uruguay", EnumDocumento.DNI, "45871265");
			controladorUsuarios.altaCliente("ejstar", "Emily", "emily.j@hotmail.com","lkjoiu987", "Johnson", new DtFecha(24, 06, 1985), "Estado Unidos", EnumDocumento.PASAPORTE, "485719842");
			controladorUsuarios.altaCliente("hernacar", "Carlos", "carlosh89@mxmail.com","poi098lkj", "Hernández",  new DtFecha(15, 9, 1988), "Mexico", EnumDocumento.PASAPORTE, "GZ1234567");
			controladorUsuarios.altaCliente("jackwil", "Jack", "jack.w.90@mail.br","asdfzxcv", "Oliveira", new DtFecha(10, 12, 1990), "Brasil", EnumDocumento.PASAPORTE, "N98123456");
			controladorUsuarios.altaCliente("juanitop", "Juan", "juanito.uy@correo.com","cde34rfv", "Pérez",  new DtFecha(12, 03, 1990), "Uruguay", EnumDocumento.DNI, "39142842");
			controladorUsuarios.altaCliente("liamth", "Liam", "liam.t.ca@mailbox.com", "bhu7vgy7","Thompson", new DtFecha(30, 11, 1992), "Canada", EnumDocumento.PASAPORTE, "AJ7684359");
			controladorUsuarios.altaCliente("marsil14", "Martín", "m.silva94@webmail.uy","vgy6cft5", "Silva", new DtFecha(14, 01, 1994), "Uruguay", EnumDocumento.PASAPORTE, "C3456789");
			controladorUsuarios.altaCliente("martig", "Marta", "marta.garcia95@webmail.es","cft5xdr4", "García", new DtFecha(05, 07, 1995), "Español", EnumDocumento.PASAPORTE, "X1245786L");
			controladorUsuarios.altaCliente("sofi89", "Sofía", "sofia.lopez@correouruguay.com","xde2zsw1", "López",  new DtFecha(25, 04, 1989), "Uruguay", EnumDocumento.PASAPORTE, "A9876543");
			
			String CA01 = "Nacionales";
			String CA02 = "Internacionales";
			String CA03 = "Europa";
			String CA04 = "America";
			String CA05 = "Exclusivos";
			String CA06 = "Temporada";
			String CA07 = "Cortos"; 

			ManRutaYVuelo.getInstancia().agregarCategoria(CA01);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA02);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA03);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA04);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA05);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA06);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA07);

			controladorVuelos.altaCiudad("Montevideo", "Uruguay", "Carrasco", "Capital uruguaya, conocida por su Rambla, arquitectura colonial y vibrante vida cultural.", "https://montevideo.gub.uy", new DtFecha(01, 04, 2024));
			controladorVuelos.altaCiudad("Múnich", "Alemania", "Aeropuerto de Múnich", "Ciudad alemana con rica historia, arquitectura barroca y vibrante vida cultural.", "https://www.munich.travel/es", new DtFecha(23, 06, 2024));
			controladorVuelos.altaCiudad("Ciudad de Panamá", "Panamá", "Tocumen", "Moderno centro urbano con rascacielos, el Canal de Panamá y vibrante vida cultural.", "https://www.atp.gob.pa/", new DtFecha(25, 06, 2024));
			controladorVuelos.altaCiudad("Buenos Aires", "Argentina", "Aeroparque Jorge Newbery", "Vibrante capital argentina, conocida por su arquitectura, tango y vida cultural.", "https://turismo.buenosaires.gob.ar/es", new DtFecha(05, 07, 2024));
			controladorVuelos.altaCiudad("Barcelona", "España", "Josep Tarradellas Barcelona–El Prat", "Ciudad catalana con arquitectura modernista, playas y vibrante vida cultural.", "https://ajuntament.barcelona.cat", new DtFecha(05, 07, 2024));
			controladorVuelos.altaCiudad("Santiago de Chile", "Chile", "Arturo Merino Benítez", "Capital chilena con moderna arquitectura, cerros y rica vida cultural.", "https://disfrutasantiago.cl", new DtFecha(06, 07, 2024));
			controladorVuelos.altaCiudad("Punta del Este", "Uruguay", "Laguna del Sauce", "Famoso balneario uruguayo, con playas, vida nocturna y lujosos resorts.", "https://www.maldonado.gub.uy", new DtFecha(15, 07, 2024));
			controladorVuelos.altaCiudad("Madrid", "España", "Adolfo Suárez Madrid-Barajas", "Vibrante capital española con rica historia, cultura y arquitectura impresionante.", "https://www.turismomadrid.es/es/", new DtFecha(12, 8, 2024));
			controladorVuelos.altaCiudad("Nueva York", "Estado Unidos", "John F. Kennedy", "Ciudad icónica con rascacielos, cultura diversa y atracciones famosas.", "https://www.nyc.gov/", new DtFecha(25, 8, 2024));
			controladorVuelos.altaCiudad("Río de Janeiro", "Brasil", "Galeão Antonio Carlos Jobim", "Ciudad costera de Brasil, famosa por sus playas y la estatua del Cristo Redentor.", "https://riotur.rio/es/bienvenido/", new DtFecha(01, 07, 2024));
			controladorVuelos.altaCiudad("Sevilla", "España", "Sevilla-San Pablo", "Sevilla, es un destino turístico fascinante que ofrece una rica mezcla de historia, cultura y belleza.", "https://visitasevilla.es/", new DtFecha(29, 02, 2024));

						

			controladorVuelos.altaRutaDeVuelo(
					"aireuropa", "UX46", 
					"Tiempo de vuelo aproximado de 12 horas con comidas incluidas", 
					new DtHora(12, 20), 
					"450", "950", "50",
					"Uruguay, Montevideo", 
					"España, Madrid",
					new DtFecha(19, 8, 2024), 
					Arrays.asList(CA02, CA03),
					"Montevideo - Madrid por Air Europa (UX46) "
			);
			
			

			controladorVuelos.altaRutaDeVuelo(
					"iberia", "IB6012", 
					"Tiempo de vuelo: cerca de 12 horas. Incluye comidas, bebidas y entretenimiento en vuelo", 
					new DtHora(13, 00), 
					"350", "1800", "60",
					"Uruguay, Montevideo", 
					"España, Madrid",
					new DtFecha(22, 8, 2024), 
					Arrays.asList(CA02, CA03, CA06),
					"Montevideo - Madrid por Iberia (IB6012)"
			);
			controladorVuelos.setEstadoRuta("IB6012", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"aerolineas", "AR1380", 
					"Tiempo de vuelo 1 hora, directo y sin escalas", 
					new DtHora(07, 55), 
					"120", "340", "30",
					"Argentina, Buenos Aires", 
					"Uruguay, Montevideo",
					new DtFecha(9, 8, 2024), 
					Arrays.asList(CA04, CA06),
					"Buenos Aires - Montevideo por Aerolíneas Argentinas (AR1380)"
			);
			controladorVuelos.setEstadoRuta("AR1380", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"aerolineas", "AR1381", 
					"Tiempo estimado de vuelo 55 minutos", 
					new DtHora(9, 35), 
					"160", "400", "30",
					"Uruguay, Montevideo", 
					"Argentina, Buenos Aires",
					new DtFecha(9, 8, 2024), 
					Arrays.asList(CA07, CA04),
					"Montevideo - Buenos Aires por Aerolíneas Argentinas (AR1381)"
			);
			controladorVuelos.setEstadoRuta("AR1381", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"zfly", "ZL1501", 
					"Viaje exclusivo en aviones pequeños, tiempo de vuelo 20 minutos", 
					new DtHora(12, 00), 
					"60", "200", "10",
					"Uruguay, Montevideo", 
					"Uruguay, Punta del Este",
					new DtFecha(11, 8, 2024), 
					Arrays.asList(CA05),
					"Montevideo - Punta del Este por Zulu Fly (ZL1501)"
			);
			controladorVuelos.setEstadoRuta("ZL1501", EnumEstado.FINALIZADA);

			controladorVuelos.altaRutaDeVuelo(
					"iberia", "IB6011", 
					"Ruta directa con tiempo aproximado de vuelo de 11 horas", 
					new DtHora(00, 10), 
					"400", "1000", "60",
					"España, Madrid", 
					"Uruguay, Montevideo",
					new DtFecha(28, 8, 2024), 
					Arrays.asList(CA06, CA03),
					"Madrid - Montevideo por Iberia (IB6011)"
			);
			controladorVuelos.setEstadoRuta("IB6011", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"aireuropa", "UX45", 
					"Ideal para quienes buscan una experiencia de vuelo sin complicaciones, con todos los servicios necesarios para un trayecto largo.", 
					new DtHora(23, 55), 
					"450", "950", "50",
					"España, Madrid", 
					"Uruguay, Montevideo",
					new DtFecha(25, 8, 2024), 
					Arrays.asList(CA03, CA02),
					"Madrid - Montevideo por Air Europa (UX45)"
			);
			controladorVuelos.setEstadoRuta("UX45", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"latam", "LA406", 
					"Tiempo de vuelo: alrededor de 2 horas y 30 minutos. Ofrece vuelos directos con servicio de bebidas y snacks a bordo.", 
					new DtHora(12, 31), 
					"100", "500", "50",
					"Chile, Santiago de Chile", 
					"Uruguay, Montevideo",
					new DtFecha(30, 07, 2024), 
					Arrays.asList(CA04, CA06),
					"Santiago de Chile - Montevideo por LATAM Airlines (LA406)"
			);
			

			controladorVuelos.altaRutaDeVuelo(
					"iberia", "IB34", 
					"Tiempo de vuelo: aproximadamente 1 hora y 20 minutos. Ofrece vuelos directos con servicio de bebidas y snacks a bordo.", 
					new DtHora(07, 05), 
					"170", "400", "20",
					"España, Madrid", 
					"España, Barcelona",
					new DtFecha(16, 8, 2024), 
					Arrays.asList(CA01, CA07),
					"Madrid - Barcelona por Iberia (IB34)"
			);
			controladorVuelos.setEstadoRuta("IB34", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"aireuropa", "UX1515", 
					"Tiempo de vuelo: aproximadamente 2 horas y 30 minutos. Ofrece vuelos directos con servicio de bebidas y snacks a bordo.", 
					new DtHora(07, 10), 
					"50", "250", "60",
					"España, Madrid", 
					"Alemania, Múnich",
					new DtFecha(22, 8, 2024), 
					Arrays.asList(CA03, CA07),
					"Madrid - Múnich por Air Europa (UX1515)"
			);
			controladorVuelos.setEstadoRuta("UX1515", EnumEstado.RECHAZADA);

			controladorVuelos.altaRutaDeVuelo(
					"copaair", "CM284", 
					"Tiempo de vuelo: aproximadamente 7 horas. Copa Airlines ofrece comidas, bebidas y entretenimiento a bordo.", 
					new DtHora(00, 30), 
					"350", "1800", "60",
					"Uruguay, Montevideo", 
					"Panamá, Ciudad de Panamá",
					new DtFecha(20, 07, 2024), 
					Arrays.asList(CA04),
					"Montevideo - Ciudad de Panamá por Copa Airlines (CM284)"
			);
			controladorVuelos.setEstadoRuta("CM284", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"copaair", "CM804", 
					"Copa Airlines ofrece comidas, bebidas y entretenimiento a bordo, asegurando una experiencia de viaje cómoda y agradable.", 
					new DtHora(18, 33), 
					"400", "1000", "15",
					"Panamá, Ciudad de Panamá", 
					"Estado Unidos, Nueva York",
					new DtFecha(27, 8, 2024), 
					Arrays.asList(CA04, CA02),
					"Ciudad de Panamá - Nueva York por Copa Airlines (CM804)"
			);
			controladorVuelos.setEstadoRuta("CM804", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"latam", "LA533", 
					"LATAM ofrece comidas, bebidas y entretenimiento a bordo para un viaje cómodo y placentero entre Estados Unidos y Chile.", 
					new DtHora(20, 05), 
					"600", "1600", "40",
					"Estado Unidos, Nueva York", 
					"Chile, Santiago de Chile",
					new DtFecha(28, 8, 2024), 
					Arrays.asList(CA02, CA06, CA04),
					"Nueva York - Santiago de Chile por LATAM Airlines (LA533)"
			);
			controladorVuelos.setEstadoRuta("LA533", EnumEstado.RECHAZADA);

			controladorVuelos.altaRutaDeVuelo(
					"copaair", "CM283", 
					"El vuelo tiene una duración aproximada de 7 horas. Ofrece comidas, bebidas y entretenimiento a bordo.", 
					new DtHora(15, 43), 
					"500", "1700", "60",
					"Panamá, Ciudad de Panamá", 
					"Uruguay, Montevideo",
					new DtFecha(14, 07, 2024), 
					Arrays.asList(CA02, CA04),
					"Ciudad de Panamá - Montevideo por Copa Airlines (CM283)"
			);
			controladorVuelos.setEstadoRuta("CM283", EnumEstado.CONFIRMADA);

			controladorVuelos.altaRutaDeVuelo(
					"latam", "LA407", 
					"El vuelo incluye bebidas y snacks a bordo, con una duración aproximada de 2 horas y 30 minutos.", 
					new DtHora(19, 40), 
					"150", "500", "50",
					"Uruguay, Montevideo", 
					"Chile, Santiago de Chile",
					new DtFecha(02, 8, 2024), 
					Arrays.asList(CA06),
					"Montevideo - Santiago de Chile por LATAM Airlines (LA407)"
			);
			

			controladorVuelos.altaRutaDeVuelo(
					"zfly", "ZL1502", 
					"Tiempo estimado de vuelo 2 horas y 30 minutos, vuelo directo.", 
					new DtHora(12, 50), 
					"75", "190", "30",
					"Uruguay, Montevideo", 
					"Brasil, Río de Janeiro",
					new DtFecha(28, 07, 2024), 
					Arrays.asList(CA02, CA04, CA07),
					"Montevideo - Río de Janeiro por Zulu Fly (ZL1502)"
			);

			controladorVuelos.altaRutaDeVuelo(
					"iberia", "IB3009", 
					"Tiempo estimado de vuelo es de 1 hora y 40 minutos.", 
					new DtHora(14, 55), 
					"140", "250", "20",
					"España, Sevilla", 
					"España, Barcelona",
					new DtFecha(20, 07, 2024), 
					Arrays.asList(CA01, CA03, CA07),
					"Barcelona - Sevilla por Iberia (IB3009)"
			);
			controladorVuelos.setEstadoRuta("IB3009", EnumEstado.CONFIRMADA);

			
			
			
			
			controladorVuelos.altaVuelo("IB6012", "IB6012272", new DtFecha(18, 11, 2024), new DtHora(11, 31), "269", "19", new DtFecha(24, 8, 2024));
			controladorVuelos.altaVuelo("IB6012", "IB6012377", new DtFecha(3, 12, 2024), new DtHora(11, 29), "269", "19", new DtFecha(29, 8, 2024));
			controladorVuelos.altaVuelo("IB6012", "IB60124102", new DtFecha(1, 12, 2024), new DtHora(11, 46), "269", "19", new DtFecha(29, 8, 2024));
			controladorVuelos.altaVuelo("IB6012", "IB60125114", new DtFecha(30, 11, 2024), new DtHora(11, 57), "269", "19", new DtFecha(28, 8, 2024));
			controladorVuelos.altaVuelo("IB6011", "IB6011651", new DtFecha(29, 11, 2024), new DtHora(11, 56), "200", "34", new DtFecha(28, 8, 2024));
			controladorVuelos.altaVuelo("IB6011", "IB6011769", new DtFecha(30, 11, 2024), new DtHora(12, 4), "200", "34", new DtFecha(29, 8, 2024));
			controladorVuelos.altaVuelo("UX45", "UX45810", new DtFecha(30, 11, 2024), new DtHora(12, 1), "150", "8", new DtFecha(29, 8, 2024));
			controladorVuelos.altaVuelo("AR1380", "AR1380939", new DtFecha(01, 11, 2024), new DtHora(0, 26), "153", "16", new DtFecha(26, 8, 2024));
			controladorVuelos.altaVuelo("AR1380", "AR13801059", new DtFecha(01, 11, 2024), new DtHora(0, 30), "162", "8", new DtFecha(27, 8, 2024));
			controladorVuelos.altaVuelo("AR1381", "AR138111124", new DtFecha(24, 11, 2024), new DtHora(0, 47), "248", "16", new DtFecha(28, 8, 2024));
			controladorVuelos.altaVuelo("AR1381", "AR1381124", new DtFecha(25, 10, 2024), new DtHora(0, 28), "162", "8", new DtFecha(14, 8, 2024));
			controladorVuelos.altaVuelo("ZL1501", "ZL15011350", new DtFecha(1, 11, 2024), new DtHora(0, 15), "2", "2", new DtFecha(27, 8, 2024));
			controladorVuelos.altaVuelo("ZL1501", "ZL15011419", new DtFecha(15, 10, 2024), new DtHora(0, 24), "2", "2", new DtFecha(26, 8, 2024));
			controladorVuelos.altaVuelo("ZL1501", "ZL15011527", new DtFecha(16, 10, 2024), new DtHora(0, 25), "0", "4", new DtFecha(16, 8, 2024));
			controladorVuelos.altaVuelo("CM284", "CM2841635", new DtFecha(28, 11, 2024), new DtHora(6, 55), "159", "20", new DtFecha(21, 8, 2024));
			controladorVuelos.altaVuelo("CM804", "CM8041764", new DtFecha(27, 1, 2025), new DtHora(4, 37), "160", "16", new DtFecha(27, 8, 2024));
			controladorVuelos.altaVuelo("IB34", "IB3418130", new DtFecha(30, 11, 2024), new DtHora(0, 54), "171", "16", new DtFecha(29, 8, 2024));
			controladorVuelos.altaVuelo("CM283", "CM2831967", new DtFecha(30, 1, 2025), new DtHora(6, 27), "146", "20", new DtFecha(3, 8, 2024));
			controladorVuelos.altaVuelo("CM284", "CM2842032", new DtFecha(03, 1, 2025), new DtHora(6, 47), "147", "20", new DtFecha(16, 8, 2024));
			controladorVuelos.altaVuelo("CM284", "CM284218", new DtFecha(29, 11, 2024), new DtHora(7, 3), "159", "20", new DtFecha(22, 7, 2024));
			controladorVuelos.altaVuelo("IB3009", "IB3009689", new DtFecha(25, 11, 2024), new DtHora(1, 40), "120", "45", new DtFecha(2, 9, 2024));


			controladorVuelos.altaPaquete("Madrid ida y vuelta","Descubre Madrid con este paquete perfecto para una escapada" //\r\n
					+ "completa. Disfruta de vuelos directos ida y vuelta, con"
					+ "cómodos horarios que te permiten aprovechar al máximo tu"
					+ "tiempo en la vibrante capital"
					+ "española.","120","50",new DtFecha(23,8,2023));

			controladorVuelos.altaPaquete("Cruzar el Charco","Escápate a Buenos Aires y"
					+ "sumérgete en la vibrante vida de"
					+ "la capital argentina. Este paquete incluye vuelos directos","150","30",new DtFecha(25,8,2024));

			controladorVuelos.altaPaquete("Recorrer España","Descubre lo mejor de España en"
					+ "un solo viaje","30","10",new DtFecha(29,8,2024));

			controladorVuelos.altaPaquete("Descubre la Ciudad de Panamá",
			"La Ciudad de Panamá es una vibrante metrópoli que combina "+
			"historia, cultura y modernidad. Conocida como el ”Corazón de "+
			"las Américas”, esta ciudad es famosa por su impresionante "+
			"Canal, una obra maestra de la ingeniería que conecta el océano Atlántico y el Pacífico."
			,"180","50",new DtFecha(21,9,2024));

			controladorVuelos.altaPaquete("Destinos Inolvidables: NY - Madrid","Nueva York, la ciudad que nunca duerme te espera con sus icónicas calles,"+
			" rascacielos impresionantes y una cultura vibrante.Sumérgete a su vez, en la ricahistoria y el arte de la capital"+
			"española, Madrid. Pasea por el majestuoso Parque del Retiro, explora el Museo del Prado y disfruta de la aut´entica gastronomía local en sus tapas y mercados"
				,"90","40",new DtFecha(25,9,2024));


			controladorVuelos.agregarRutaVueloPaquete("Madrid ida y vuelta", "IB6012", 1, EnumAsiento.ejecutivo);
			controladorVuelos.agregarRutaVueloPaquete("Madrid ida y vuelta", "IB6011", 1, EnumAsiento.ejecutivo);

			//controladorVuelos.agregarRutaVueloPaquete("Cruzar el Charco", "AR1380", 2, EnumAsiento.turista);
			controladorVuelos.agregarRutaVueloPaquete("Cruzar el Charco", "AR1381", 3, EnumAsiento.ejecutivo);

			controladorVuelos.agregarRutaVueloPaquete("Recorrer España", "IB34", 1, EnumAsiento.turista);
			controladorVuelos.agregarRutaVueloPaquete("Recorrer España", "IB6012", 1, EnumAsiento.turista);
			controladorVuelos.agregarRutaVueloPaquete("Recorrer España", "IB3009", 1, EnumAsiento.turista);

			controladorVuelos.agregarRutaVueloPaquete( "Descubre la Ciudad de Panamá", "CM284", 2, EnumAsiento.turista);
			controladorVuelos.agregarRutaVueloPaquete( "Descubre la Ciudad de Panamá", "CM283", 2, EnumAsiento.ejecutivo);

			controladorVuelos.agregarRutaVueloPaquete( "Destinos Inolvidables: NY - Madrid", "IB6012", 4, EnumAsiento.turista);
			controladorVuelos.agregarRutaVueloPaquete( "Destinos Inolvidables: NY - Madrid", "CM804", 2, EnumAsiento.ejecutivo);


			controladorVuelos.altaCompraPaquete("Cruzar el Charco", "sofi89", new DtFecha(26,8,2024));
			controladorVuelos.altaCompraPaquete("Madrid ida y vuelta", "sofi89", new DtFecha(26,8,2024));
			controladorVuelos.altaCompraPaquete("Madrid ida y vuelta", "martig", new DtFecha(27,8,2024));
			controladorVuelos.altaCompraPaquete("Cruzar el Charco", "ejstar", new DtFecha(26,8,2024));
			controladorVuelos.altaCompraPaquete("Descubre la Ciudad de Panamá", "juanitop", new DtFecha(1,9,2024));
			controladorVuelos.altaCompraPaquete("Descubre la Ciudad de Panamá", "hernacar", new DtFecha(14,10,2024));
			
			controladorVuelos.altaCompraPaquete("Madrid ida y vuelta", "hernacar", new DtFecha(27,8,2023));
			
			
			controladorVuelos.altaReserva("hernacar", "IB6012272", EnumAsiento.turista, 2, 1, new DtFecha(28,8,2024), false, Map.of("Carlos", "Hernández"));
			controladorVuelos.altaReserva("jackwil", "IB6012272", EnumAsiento.ejecutivo, 4, 2,  new DtFecha(29,8,2024), false, Map.of("Jack", "Olivera","Jill", "Perk"));
			controladorVuelos.altaReserva("csexto", "ZL15011350", EnumAsiento.turista, 0, 2,  new DtFecha(30,8,2024), false, Map.of("Cristian", "Sexto","Marta", "Lopez"));
			controladorVuelos.altaReserva("anarod87", "ZL15011350", EnumAsiento.ejecutivo, 2, 2,new DtFecha(30,8,2024), false, Map.of("Ana", "Rodríguez","Lucas", "Morales"));
			controladorVuelos.altaReserva("juanitop", "ZL15011419", EnumAsiento.turista, 1, 2,  new DtFecha(27,8,2024), false, Map.of("Juan", "Pérez","Franco", "Gonzalez"));
			controladorVuelos.altaReserva("ejstar", "AR13801059", EnumAsiento.ejecutivo, 5, 8,  new DtFecha(28,8,2024 ), false, Map.of("Emily", "Johnson","Jack", "Jhonson","Liberty", "Trent", "Marc", "Ruffalo","Jessica", "Landon","Robert", "Shank", "Frank", "Trent","Lucy", "Felton"));
			
			Cliente ejstarC = controladorUsuarios.getCliente("ejstar");
			controladorVuelos.altaReserva("ejstar", "AR1381124", EnumAsiento.ejecutivo, 3, 3,  new DtFecha(29,8,2024), true, Map.of("Emily", "Johnson","Jack","Johnson","Trent","Johnson"));
			
			controladorVuelos.altaReserva("ejstar", "AR138111124", EnumAsiento.ejecutivo, 1, 1, new DtFecha(30,8,2024), false, Map.of("Emily", "Johnson"));
			
			Cliente juanitopC = controladorUsuarios.getCliente("juanitop");
			Cliente hernacarC = controladorUsuarios.getCliente("hernacar");
			controladorVuelos.altaReserva("juanitop", "CM2841635", EnumAsiento.turista, 1, 1, new DtFecha(30,9,2024), true, Map.of("Juan", "Pérez"));
			controladorVuelos.altaReserva("hernacar", "CM2842032", EnumAsiento.turista, 1, 2, new DtFecha(1,10,2024), true, Map.of("Carlos", "Hernández","Marta","Lima"));
			controladorVuelos.altaReserva("hernacar", "CM2831967", EnumAsiento.ejecutivo, 2, 2, new DtFecha(1,10,2024), true, Map.of("Carlos", "Hernández","Marta","Lima"));
			//altaReserva(String cliente, String vuelo, EnumAsiento tipoAsiento, int equipajeExtra, int pasajes, double costoFinal,DTFecha fechaActual,CompraPaquete cPaquete,Map<String,String> personas)
				
			controladorVuelos.realizarCheckIn("hernacar", "IB6012272");
			controladorVuelos.realizarCheckIn("jackwil", "IB6012272");
			controladorVuelos.realizarCheckIn("csexto", "ZL15011350");
			controladorVuelos.realizarCheckIn("anarod87", "ZL15011350");
			controladorVuelos.realizarCheckIn("juanitop", "ZL15011419");
			controladorVuelos.realizarCheckIn("ejstar", "AR1381124");

			
			
		}catch(SetException err){
			String mensajeError = "Se encontraron errores: \n";
            for (String mErr : err.getErrorSet()) {
                mensajeError+=mErr +"\n";
            }
            System.out.println(mensajeError);
		}
	}
}
