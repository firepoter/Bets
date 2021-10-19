package dataAccess;


import configuration.ConfigXML;



public class ObjectdbManagerServerAWS {



	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
		
		if (c.isDatabaseLocal()) {
			System.out.println("\nERROR, the database is configured as local");
		}
		else {
		accesDb(c);
		
		}
	}

	private static void accesDb(ConfigXML c) {
		try{

			System.out.println("Lauching objectdb server");
		    lMaq(c);
			
		    System.out.println("\nAccess granted to: "+c.getUser());
		    
		    System.out.println("\nPress key to exit this database server... ");
		    
		    while(System.in.available()==0){
		    	Thread.sleep(1000);
		    	}
			
		} catch (Exception e) {
			System.out.println("Something has happened in ObjectdbManagerServer: "+e.toString());

		}
	}

	private static void lMaq(ConfigXML c) {
		try { // Se va a ejecutar en m�quina Linux: usar "/"
			String st="java -cp resources/objectdb.jar com.objectdb.Server -port "+ c.getDatabasePort()+" start";
			System.out.println(st);
			Runtime.getRuntime().exec(st);
		} catch (Exception ioe) {
			System.out.println (ioe);
		}
	}
		
	}


