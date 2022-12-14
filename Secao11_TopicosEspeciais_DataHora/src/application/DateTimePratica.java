package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimePratica {

	public static void main(String[] args) {

		System.out.println("Varias formas de manipular Objetos Data Hora:");
		System.out.println();
		// Instancia Data atual
		LocalDate d01 = LocalDate.now();
		System.out.println("Data LOCAL atual (ISO 8601): " + d01.toString());
		
		LocalDate d04 = LocalDate.parse("2022-12-25");
		System.out.println("Data LOCAL definida pelo usuario: " + d04);
		
		// Instancia Data Hora atual
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("Data e hora LOCAL atual: " + d02);
		
		LocalDateTime d05 = LocalDateTime.parse("2022-12-26T23:30:45");
		System.out.println("Data e hora LOCAL definida pelo user: " + d05);

		Instant d03 = Instant.now();
		System.out.println("Date e hora GLOBAL (GMT 00) atual: " + d03);
		
		Instant d06 = Instant.parse("2022-12-27T01:40:20Z");
		System.out.println("Date e hora GLOBAL (GMT 00) definida: " + d06);
		
		Instant d07 = Instant.parse("2022-12-27T22:30:20-03:00");
		System.out.println("Date e hora GLOBAL (GMT 00) definida convertida para GMT 0: " + d07);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("28/10/2022", fmt1);
		System.out.println("Data local: formato Brasil -> ISO 8601: " + d08);
		
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d09 = LocalDateTime.parse("28/10/2022 15:45", fmt2);
		System.out.println("Data Hora local: formato Brasil -> ISO 8601: " + d09);
		
		LocalDate d10 = LocalDate.of(2022, 10, 28);
		System.out.println("Data local: ano, mes, dia isolados -> ISO 8601: " + d10);
		
		LocalDateTime d11 = LocalDateTime.of(2022, 10, 29, 15, 45);
		System.out.println("Data local: ano, mes, dia, hora e min isolados -> ISO 8601: " + d11);
		
		System.out.println("---------------------------");
		System.out.println("Formatando Objetos Data Hora -> String:");
		System.out.println();
		
		// LocalDate d04 = LocalDate.parse("2022-12-25");
		DateTimeFormatter fmtDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Imprimindo Data ISO 8601 -> Brasil d04.format(fmt): "+ d04.format(fmtDataBrasil));
		System.out.println("Imprimindo Data ISO 8601 -> Brasil fmt.format(d04): "+ fmtDataBrasil.format(d04));
		
		// LocalDateTime d05 = LocalDateTime.parse("2022-12-26T23:30:45");
		DateTimeFormatter fmtDataHoraBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println("Imprimindo Data Hora ISO 8601 -> Brasil: "+ d05.format(fmtDataHoraBrasil));
		
		DateTimeFormatter fmtComConstante = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println("Imprimindo ISO 8601 GLOBAL com constante ISO_DATE_TIME: " +
				fmtComConstante.format(d05));
		
		// Instant d06 = Instant.parse("2022-12-27T01:40:20Z");
		DateTimeFormatter fmtDataHoraGlobal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").
				withZone(ZoneId.systemDefault());
		System.out.println("Imprimindo ISO 8601 GLOBAL -> Brasil (classe Instant nao tem 'format()') " +
				fmtDataHoraGlobal.format(d06));
		
		DateTimeFormatter fmtDtHrGlobalConstante = DateTimeFormatter.ISO_INSTANT;
		System.out.println("Imprimindo ISO 8601 GLOBAL com constante ISO_INSTANT: "+ fmtDtHrGlobalConstante.format(d06));
		
		System.out.println("---------------------------");
		System.out.println("Convertendo DataHora Global para Local e Vice-Versa: ");
		System.out.println();
		
		// LocalDate d04 = LocalDate.parse("2022-12-25");
		// LocalDateTime d05 = LocalDateTime.parse("2022-12-26T23:30:45");
		// Instant d06 = Instant.parse("2022-12-27T01:40:20Z");
		
//		for (String s : ZoneId.getAvailableZoneIds()) {
//			System.out.println(s);
//		}
		
		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
		System.out.println("Data de GMT 0 (Global) para Maquina local (Brasil/SP GMT - 3): " + r1);

		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		System.out.println("Data e Hora de GMT 0 (Global) para Maquina local (Brasil/SP GMT - 3): " + r3);
		
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		System.out.println("Data de GMT 0 (Global) para Portugal (GMT + 1): " + r2);
		
		LocalDate r4 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		System.out.println("Data e Hora de GMT 0 (Global) para Portugal (GMT + 1): " + r4);
		
		System.out.println();
		System.out.println("Somente 'dia': "+ d04.getDayOfMonth());
		System.out.println("Somente 'mes': "+ d04.getMonthValue());
		System.out.println("Somente 'mes por extenso': "+ d04.getMonth());
		System.out.println("Somente 'ano': "+ d04.getYear());
		
		System.out.println();
		System.out.println("Somente 'hora': "+d05.getHour());
		System.out.println("Somente 'minuto': "+ d05.getMinute());
		
		System.out.println("---------------------------");
		System.out.println("Calculos com DataHora: ");
		System.out.println("Obs: Objetos DataHora sao estaticos, nao se alteram!");
		System.out.println("Resultados da operacao geram novo objeto DataHora. ");
		System.out.println();
		
		// LocalDate d04 = LocalDate.parse("2022-12-25");
		// LocalDateTime d05 = LocalDateTime.parse("2022-12-26T23:30:45");
		// Instant d06 = Instant.parse("2022-12-27T01:40:20Z");
		
		LocalDate pastWeekLocalDate = d04.minusDays(7);
		System.out.println("Subtraindo uma semana da Data:" + pastWeekLocalDate);	
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		System.out.println("Somando uma semana da Data:" + nextWeekLocalDate);
		
		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		System.out.println("Subtraindo uma semana de DataHora:" + pastWeekLocalDateTime);	
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
		System.out.println("Somando uma semana de DataHora:" + nextWeekLocalDateTime);
		
		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		System.out.println("Subtraindo uma semana de Instant:" + pastWeekInstant);	
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
		System.out.println("Somando uma semana de Instant:" + nextWeekInstant);
				
		Duration diferencaLocalDateTime = Duration.between(pastWeekLocalDateTime, d05);
		System.out.println("Diferenca de Dias em LocalDateTIME (NAO FUNFA PRA LocalDate. Precisa converter para LocalDateTime): "
				+ diferencaLocalDateTime.toDays());
		Duration diferencaLocalDate = Duration.between(pastWeekLocalDate.atTime(0, 0), d04.atTime(0, 0));
		System.out.println("Diferenca de Dias em LocalDate (convertido para LocalDateTime com atTime(0, 0)): "
				+ diferencaLocalDate.toDays());
		diferencaLocalDate = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
		System.out.println("Diferenca de Dias em LocalDate (usando atStartOfDay() ao inves de atTime(0, 0)): "
				+ diferencaLocalDate.toDays());
		
		Duration diferencaInstant = Duration.between(pastWeekInstant, d06);
		System.out.println("Diferenca de Dias em Instant: " + diferencaInstant.toDays());
		
		diferencaInstant = Duration.between(d06, pastWeekInstant);
		System.out.println("Diferenca de Dias em Instant (invertendo operadores) : " + diferencaInstant.toDays());
	}

}