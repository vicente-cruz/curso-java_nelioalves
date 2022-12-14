package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateCalendarLegado {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d1 = sdf1.parse("31/10/2022");
		Date d2 = sdf2.parse("31/10/2022 14:30:25");
		
		System.out.println("Data com objeto sdf1: " + d1);
		System.out.println("Data com objeto sdf2: " + d2);
		
		System.out.println("Data com formato da instancia de sdf1: " + sdf1.format(d1));
		System.out.println("Data com formato da instancia de sdf2: " + sdf2.format(d2));
		
		Date now1 = new Date();
		Date now2 = new Date(System.currentTimeMillis());
		System.out.println("Data atual: " + sdf2.format(now1));
		System.out.println("Data atual com currentTimeMillis(): " + sdf2.format(now2));
		
		Date epoch01 = new Date(0L);
		System.out.println("Inicio dos tempos, mas com GMT-3 (Brasil): " + sdf2.format(epoch01));
		Date epoch02 = new Date(1000L * 60L * 60L * 5L);
		System.out.println("5 horas após onicio dos tempos, mas com GMT-3 (Brasil): " + sdf2.format(epoch02));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date d3 = Date.from(Instant.parse("2022-10-31T14:30:25Z"));
		
		System.out.println("------------------");
		
		System.out.println("Data com formato da instancia de sdf1: " + sdf3.format(d1));
		System.out.println("Data com formato da instancia de sdf2: " + sdf3.format(d2));
		System.out.println("Data atual: " + sdf3.format(now1));
		System.out.println("Inicio dos tempos: " + sdf3.format(epoch01));
		System.out.println("5 horas após onicio dos tempos: " + sdf3.format(epoch02));
		
		System.out.println("---------------------");
		System.out.println("Lidando com Date e Calendar: operacoes com datas legado.");
		
		SimpleDateFormat sdfCal = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dCal = Date.from(Instant.parse("2022-10-31T15:30:10Z"));
		System.out.println(sdfCal.format(dCal));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dCal);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		dCal = cal.getTime();
		System.out.println("Somou 4 horas: " + dCal);
		
		int min = cal.get(Calendar.MINUTE);
		System.out.println("Minutos: " + min);
		
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("Mes (Janeiro = 0): " + month);
	}

}
