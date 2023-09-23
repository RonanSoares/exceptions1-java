/* Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e 
data de saída) e mostrar os dados da reserva, inclusive sua duração em dias. Em seguida, ler novas 
datas de entrada e saída, atualizar a reserva, e mostrar novamente a reserva com os dados atualizados. 
O programa não deve aceitar dados inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada  */

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.xml.crypto.Data;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados solicitados");
		System.out.println("------------------------------------------");
		System.out.print("Número do quarto            : ");
		int nrQuarto = sc.nextInt();
		System.out.print("Data de entrada(dd/MM/yyyy) : ");
		Date dataEnt = sdf.parse(sc.next());
		System.out.print("Data de saída(dd/MM/yyyy)   : ");
		Date dataSai = sdf.parse(sc.next());
		System.out.println("========================================");

		if (!dataSai.after(dataEnt)) {
			System.out.println("Erro de reserva...");
			System.out.println("Data de saída não pode ser menor que data de entrada");
		} else {
			Reserva res = new Reserva(nrQuarto, dataEnt, dataSai);
			System.out.println("Reservas: ");
			System.out.println("--------");
			System.out.println(res.toSgtring());
			System.out.println("===========================================");

			System.out.println("Entre com os dados para atualizar a reserva");
			System.out.print("Data de entrada(dd/MM/yyyy) : ");
			dataEnt = sdf.parse(sc.next());
			System.out.print("Data de saída(dd/MM/yyyy)   : ");
			dataSai = sdf.parse(sc.next());

			System.out.println("===========================================");
			System.out.println("Reservas: ");
			System.out.println("--------");

			Date atual = new Date();
			if (dataEnt.before(atual) || dataSai.before(atual)) {
				System.out.println("Erro de reserva...");
				System.out.println("As datas devem ser futuras...");
			} else if (!dataSai.after(dataEnt)){
				System.out.println("Erro de reserva...");
				System.out.println("Data de saída tem que ser posterior a data de entrada");
				
			}else {
				res.attDatas(dataEnt, dataSai);
				System.out.println(res.toSgtring());
			}

		}

		System.out.println("===========================================");

		sc.close();

	}
}
