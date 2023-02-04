package com.example.consultaFrete.types;

public enum State {
    AMAZONAS("AM"),
    ALAGOAS("AL"),
    ACRE("AC"),
    AMAPA("AP"),
    BAHIA("BA"),
    PARA("PA"),
    MATO_GROSSO("MT"),
    MINAS_GERAIS("MG"),
    MATO_GROSSO_DO_SUL("MS"),
    GOIAS("GO"),
    MARANHAO("MA"),
    RIO_GRANDE_DO_SUL("RS"),
    TOCANTINS("TO"),
    PIAUI("PI"),
    SAO_PAULO("SP"),
    RONDONIA("RO"),
    RORAIMA("RR"),
    PARANA("PR"),
    CEARA("CE"),
    PERNAMBUCO("PE"),
    SANTA_CATARINA("SC"),
    PARAIBA("PB"),
    RIO_GRANDE_DO_NORTE("RN"),
    ESPIRITO_SANTO("ES"),
    RIO_DE_JANEIRO("RJ"),
    SERGIPE("SE"),
    DISTRITO_FEDERAL("DF");
  
    private final String uf;

    State(final String uf) {
      this.uf = uf;
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