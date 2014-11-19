package com.jingyusoft.amity.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HostPort {

	public static final HostPort from(final String host, final int port) {
		return new HostPort(host, port);
	}

	@SerializedName("host")
	@Expose
	private final String host;

	@SerializedName("port")
	@Expose
	private final int port;

	public HostPort(final String host, final int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HostPort other = (HostPort) obj;
		if (host == null) {
			if (other.host != null) {
				return false;
			}
		} else if (!host.equals(other.host)) {
			return false;
		}
		if (port != other.port) {
			return false;
		}
		return true;
	}

	public final String getHost() {
		return host;
	}

	public final int getPort() {
		return port;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (host == null ? 0 : host.hashCode());
		result = prime * result + port;
		return result;
	}

	public final String toJson() {
		return JsonUtils.toJson(this);
	}

	@Override
	public String toString() {
		return host + ":" + port;
	}
}
