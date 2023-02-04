package com.example.consultaFrete.types;

import lombok.Getter;

public enum State {
    AMAZONAS("AM", Region.NORTE),
    ALAGOAS("AL", Region.NORDESTE),
    ACRE("AC", Region.NORTE),
    AMAPA("AP", Region.NORTE),
    BAHIA("BA", Region.NORDESTE),
    PARA("PA", Region.NORTE),
    MATO_GROSSO("MT", Region.CENTRO_OESTE),
    MINAS_GERAIS("MG", Region.SUDESTE),
    MATO_GROSSO_DO_SUL("MS", Region.CENTRO_OESTE),
    GOIAS("GO", Region.CENTRO_OESTE),
    MARANHAO("MA", Region.NORDESTE),
    RIO_GRANDE_DO_SUL("RS", Region.SUL),
    TOCANTINS("TO", Region.NORTE),
    PIAUI("PI", Region.NORDESTE),
    SAO_PAULO("SP", Region.SUDESTE),
    RONDONIA("RO", Region.NORTE),
    RORAIMA("RR", Region.NORTE),
    PARANA("PR", Region.SUL),
    CEARA("CE", Region.NORDESTE),
    PERNAMBUCO("PE", Region.NORDESTE),
    SANTA_CATARINA("SC", Region.SUL),
    PARAIBA("PB", Region.NORDESTE),
    RIO_GRANDE_DO_NORTE("RN", Region.NORDESTE),
    ESPIRITO_SANTO("ES", Region.SUDESTE),
    RIO_DE_JANEIRO("RJ", Region.SUDESTE),
    SERGIPE("SE", Region.NORDESTE),
    DISTRITO_FEDERAL("DF", Region.CENTRO_OESTE);
  
    private final String uf;
    @Getter private final Region region;

    State(final String uf, final Region region) {
      this.uf = uf;
      this.region = region;
    }

    public static State fromUF(final String uf) {
      for (final State state : State.values()) {
        if (state.uf.equalsIgnoreCase(uf)) {
          return state;
        }
      }
  
      throw new IllegalArgumentException(uf);
    }
  
    @Override
    public String toString() {
        return this.uf;
    }
  }