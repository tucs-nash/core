package com.tucs.core.model.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.joda.ser.JacksonJodaFormat;
import com.fasterxml.jackson.datatype.joda.ser.JodaDateSerializerBase;
import org.joda.time.LocalDate;

import java.io.IOException;

/**
 * Created by farrells on 03/09/2014.
 */
public class LocalDateSerializer extends JodaDateSerializerBase<LocalDate> {
    protected final static JacksonJodaFormat DEFAULT_FORMAT
            = new JacksonJodaFormat(DEFAULT_DATEONLY_FORMAT);

    public LocalDateSerializer() { this(DEFAULT_FORMAT); }
    public LocalDateSerializer(JacksonJodaFormat format) {
        super(LocalDate.class, format);
    }

    @Override
    public LocalDateSerializer withFormat(JacksonJodaFormat formatter) {
        return (_format == formatter) ? this : new LocalDateSerializer(formatter);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonGenerationException {

        jgen.writeString(_format.createFormatter(provider).print(value));
    }
}
