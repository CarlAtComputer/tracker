package pt.caughtonnet.tracker.rest.courier;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import pt.caughtonnet.tracker.api.clerk.Courier;
import pt.caughtonnet.tracker.api.config.ConfigurableElement;
import pt.caughtonnet.tracker.api.model.Track;
import pt.caughtonnet.tracker.rest.courier.config.RestCourierConfiguration;

public class RestCourier implements Courier, ConfigurableElement<RestCourierConfiguration> {

	private String endpoint;

	protected String resourceUrl;
	protected Client client;
	protected Builder builder;
	private WebTarget target;

	@Override
	public void dispatch(Track track) {
		try {
			Entity t = Entity.entity(track, MediaType.APPLICATION_JSON);
			builder.post(t);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dispatch(Collection<? extends Track> tracks) {
		for (Track track : tracks) {
			dispatch(track);
		}
	}

	@Override
	public Class<RestCourierConfiguration> getConfigurationBean() {
		return RestCourierConfiguration.class;
	}

	@Override
	public void configure(RestCourierConfiguration config) {
		this.endpoint = config.getEndpoint();
	}

	@Override
	public void setup() {
		ClientConfig config = new ClientConfig();
		this.client = ClientBuilder.newClient(config);
		JacksonJsonProvider jacksonJsonProvider = new JacksonJaxbJsonProvider().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		client.register(jacksonJsonProvider);
		target = client.target(endpoint);
		builder = target.request(MediaType.APPLICATION_JSON);
	}

}
