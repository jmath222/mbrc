package com.kelsos.mbrc.domain;

import android.support.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties({ "index" }) public class ConnectionSettings
    implements Comparable<ConnectionSettings> {
  private String address;
  private String name;
  private int port;
  private int http;
  private int index;

  public ConnectionSettings(JsonNode node) {
    initFromJson(node);
    this.index = -1;
  }

  public ConnectionSettings(String address, String name, int port, int index, int http) {
    this.address = address;
    this.name = name;
    this.port = port;
    this.index = index;
    this.http = http;
  }

  public ConnectionSettings() {
    this.address = "";
    this.index = -1;
    this.port = 0;
    this.name = "";
  }

  private void initFromJson(JsonNode node) {
    this.address = node.path("address").asText();
    this.name = node.path("name").asText();
    this.port = node.path("port").asInt();
    this.http = node.path("http").asInt();
  }

  public void updateIndex(int index) {
    this.index = index;
}

  public String getAddress() {
    return this.address;
  }

  public String getName() {
    return this.name;
  }

  public int getPort() {
    return this.port;
  }

  public int getHttp() {
    return this.http;
  }

  @Override public boolean equals(Object o) {
    boolean equality = false;

    if (o instanceof ConnectionSettings) {
      ConnectionSettings other = (ConnectionSettings) o;
      equality = other.getAddress().equals(address) && other.getPort() == port;
    }
    return equality;
  }

  @Override public int hashCode() {
    int hash = 0x192;
    hash = hash * 17 + port;
    hash = hash * 31 + address.hashCode();
    return hash;
  }

  public int getIndex() {
    return index;
  }

  /**
   * Compares this object to the specified object to determine their relative
   * order.
   *
   * @param another the object to compare to this instance.
   * @return a negative integer if this instance is less than {@code another};
   * a positive integer if this instance is greater than
   * {@code another}; 0 if this instance has the same order as
   * {@code another}.
   * @throws ClassCastException if {@code another} cannot be converted into something
   * comparable to {@code this} instance.
   */
  @Override public int compareTo(@NonNull ConnectionSettings another) {
    int compare = 0;

    if (index < another.index) {
      compare = -1;
    } else if (index > another.index) {
      compare = 1;
    }
    return compare;
  }
}
