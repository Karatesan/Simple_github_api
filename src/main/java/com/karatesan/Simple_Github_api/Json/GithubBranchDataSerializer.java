package com.karatesan.Simple_Github_api.Json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.karatesan.Simple_Github_api.dto.GithubBranchData;
import java.io.IOException;

/**
 * Custom JSON serializer for {@link GithubBranchData}.
 * <p>
 * This serializer customizes the JSON output for instances of {@link GithubBranchData}.
 * Instead of serializing the entire {@code GithubBranchData} object, it extracts and
 * serializes only the branch name and the commit SHA as standalone fields.
 * </p>
 * <p>
 * This approach avoids introducing another DTO class and simplifies the response format.
 * </p>
 */
public class GithubBranchDataSerializer extends JsonSerializer<GithubBranchData> {

    /**
     * Serializes {@link GithubBranchData} into a JSON object with the following fields:
     * <ul>
     *     <li>{@code branchName} - the name of the branch</li>
     *     <li>{@code sha} - the SHA of the last commit</li>
     * </ul>
     *
     * @param value the {@code GithubBranchData} instance to serialize
     * @param jsonGenerator used to write JSON content
     * @param serializerProvider provides additional context for serialization
     * @throws IOException if an I/O error occurs during serialization
     */
    @Override
    public void serialize(GithubBranchData value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("branchName", value.getName());
        jsonGenerator.writeStringField("sha", value.getCommit().getSha());
        jsonGenerator.writeEndObject();
    }
}
