package com.github.baas.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class JsonDataLoader {

	private String getJsonFileNameByFileName(String fileName) {
		return String.format("%s.json", fileName.replaceAll("\\.", "/"));
	}

	public <T> T loadEntity(String fileName, Class<T> valueType)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String name = getJsonFileNameByFileName(fileName);
		String data = IOUtils.toString(getClass().getResourceAsStream(name), Charset.forName("UTF-8"));
		return mapper.readValue(data, valueType);
	}

}
