package com.github.baas.utils;

import com.github.baas.infrstructure.json.Mapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class JsonDataLoader {

	private String getJsonFileNameByFileName(String fileName) {
		return String.format("%s.json", fileName.replaceAll("\\.", "/"));
	}

	public <T> Optional<T> loadEntity(String fileName, Class<T> valueType) {
		String name = getJsonFileNameByFileName(fileName);
		try {
			String data = IOUtils.toString(getClass().getResourceAsStream(name), StandardCharsets.UTF_8);
			return Optional.of(Mapper.objectMapper.readValue(data, valueType));
		} catch (IOException e) {
			return Optional.empty();
		}
	}

}
