public class Main {
    public static void main(String[] args) {
        // --- Observer Pattern ---
        System.out.println("===== Observer Pattern =====");

        // Akıllı cihaz (Light) ve kullanıcının uygulaması (UserApp)
        SmartDevice light = new SmartDevice("Living Room Light");
        UserApp userApp = new UserApp();

        // UserApp'ı light cihazına gözlemci olarak ekliyoruz
        light.addObserver(userApp);

        // Cihazın durumunu değiştiriyoruz ve gözlemciye bildirim gidiyor
        System.out.println("Turning the light ON");
        light.setState(true);  // Kullanıcıya bildirim yapılacak

        System.out.println("Turning the light OFF");
        light.setState(false); // Kullanıcıya bildirim yapılacak


        // --- Visitor Pattern ---
        System.out.println("\n===== Visitor Pattern =====");

        // Farklı cihaz türlerinin (Light, Thermostat) teşhisini yapacak ziyaretçi (visitor)
        Light livingRoomLightVisitor = new Light();
        Thermostat smartThermostatVisitor = new Thermostat();
        DiagnosticVisitor diagnosticVisitor = new DiagnosticVisitor();

        // Her bir cihazın üzerinde ziyaretçi işlemi uygulanıyor
        livingRoomLightVisitor.accept(diagnosticVisitor);  // Işık üzerinde teşhis
        smartThermostatVisitor.accept(diagnosticVisitor);  // Termostat üzerinde teşhis


        // --- Mediator Pattern ---
        // --- Mediator Pattern ---
        System.out.println("\n===== Mediator Pattern =====");

// SmartHomeHub aracılığıyla cihazlar arasındaki etkileşimi yöneten medyatör
        SmartHomeHub hub1 = new SmartHomeHub();
        SmartHomeHub hub2 = new SmartHomeHub();

// Hub'lara cihazları kaydediyoruz
        hub1.registerDevice("Living Room Light", light);
        hub2.registerDevice("Living Room Light", light);

// Hub1 üzerinden ışığı açıp kapatıyoruz
        System.out.println("Sending command to turn the light OFF via Hub1");
        hub1.sendCommand("Living Room Light", false);  // Hub1 üzerinden komut gönderiliyor

// Hub2 üzerinden ışığı açıp kapatıyoruz
        System.out.println("Sending command to turn the light ON via Hub2");
        hub2.sendCommand("Living Room Light", true);  // Hub2 üzerinden komut gönderiliyor


        // --- Template Pattern ---
        System.out.println("\n===== Template Pattern =====");

        // Işık kurulumu için Template kullanımı
        DeviceSetup lightSetup = new LightSetup();
        lightSetup.setupDevice();  // Işığın kurulumu şablona göre yapılıyor


        // --- Chain of Responsibility Pattern ---
        System.out.println("\n===== Chain of Responsibility Pattern =====");

        // İstekleri sırayla işleyen handler'lar
        RequestHandler powerHandler = new PowerHandler();
        RequestHandler alertHandler = new AlertHandler();

        // Handlers arasında geçiş yapabilmesi için bağlanıyorlar
        powerHandler.setNextHandler(alertHandler);
        System.out.println("Processing request: RaiseAlert");
        powerHandler.handleRequest("RaiseAlert");  // AlertHandler, alarm verecek

        // Farklı istekleri ele alıyoruz
        System.out.println("Processing request: TurnOffDevices");
        powerHandler.handleRequest("TurnOffDevices");  // PowerHandler, cihazları kapatacak


        // --- State Pattern ---
        System.out.println("\n===== State Pattern =====");

        // Termostatın durumları değişiyor (Cooling -> Heating)
        ThermostatContext thermostatContext = new ThermostatContext();

        // Termostat ilk başta soğutma modunda
        thermostatContext.setState(new CoolingState());
        thermostatContext.applyState();  // Soğutma modunun uygulanması

        // Termostat daha sonra ısınma moduna geçiyor
        thermostatContext.setState(new HeatingState());
        thermostatContext.applyState();  // Isınma modunun uygulanması
    }
}
