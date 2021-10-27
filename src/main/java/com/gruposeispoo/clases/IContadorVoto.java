package com.gruposeispoo.clases;

public interface IContadorVoto {
    int contarVotosBlanco();
    int contarVotosBlanco (TipoCandidato tipoCandidato);
    int contarVotos (Candidato candidato);
    int contarVotos (ListaPolitica listaPolitica);
}
