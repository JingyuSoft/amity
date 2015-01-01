package com.jingyusoft.amity.programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.queryparser.classic.ParseException;

import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.refdata.CitySearcher;
import com.jingyusoft.amity.refdata.NearestCityResult;

public class CitySearchConsole extends TestConsoleBase {

	@Resource
	private CitySearcher citySearcher;

	private String readStdin() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return StringUtils.trimToEmpty(br.readLine());
		} catch (IOException e) {
			throw WrappedException.insteadOf(e);
		}
	}

	@Override
	protected void startConsole() {

		String line = null;
		while (true) {

			if (StringUtils.equalsIgnoreCase(line = readStdin(), "exit")) {
				break;
			}

			if (StringUtils.isNotBlank(line)) {
				if (StringUtils.startsWith(line, "(") && StringUtils.endsWith(line, ")")) {
					String[] elements = line.substring(1, line.length() - 1).trim().split(",");
					NearestCityResult nearestCityResult = citySearcher.getNearestCity(
							Double.parseDouble(elements[0].trim()), Double.parseDouble(elements[1].trim()));
					System.err.println(nearestCityResult);
				} else {
					try {
						citySearcher.searchCitiesByName(line, 10);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}

		System.out.println("Exited loop...");
	}
}
