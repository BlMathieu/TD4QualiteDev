package ecommerceProxy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Dataset {

	private Collection<Transaction> trans;
	private Article[] articles;

	private static Dataset dataset;

	private Dataset() throws IOException {

		articles = new Article[trans.size()];

		for (int i = 0; i < trans.size(); i++)
			articles[i] = new Article(i);

		trans = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(trans.datasetPath));
		String line;
		// for each line (transactions) until the end of the file
		while (((line = reader.readLine()) != null)) {
			// if the line is a comment, is empty or is a
			// kind of metadata
			if (line.isEmpty() == true || line.charAt(0) == '#' || line.charAt(0) == '%' || line.charAt(0) == '@') {
				continue;
			}
			// split the line according to spaces
			String[] lineSplited = line.split(" ");

			// create an array of int to store the items in this transaction
			Transaction transaction = new Transaction();

			// for each item in this line (transaction)
			for (int i = 0; i < lineSplited.length; i++) {

				int item = Integer.parseInt(lineSplited[i]);

				transaction.add(articles[item]);

			}
			trans.add(transaction);

		}

		// close the input file
		reader.close();

	}

	public ArrayList<Motif> motifParser() throws IOException {
		return new ArrayList<>();
		//TODO
	}



}
