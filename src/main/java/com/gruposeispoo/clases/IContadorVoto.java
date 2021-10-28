package com.gruposeispoo.clases;

public interface IContadorVoto {
    /**
     *
     * @return cantidad de votos en blancos totales.
     */
    int contarVotosBlanco();
    /**
     *
     * @param tipoCandidato, El tipo de candidato que es (senador o diputado).
     * @return devuelve la cantidad de votos en blanco de este tipo de candidato.
     */
    int contarVotosBlanco (TipoCandidato tipoCandidato);

    /**
     *
     * @return cantidad de votos generales.
     */
    int contarVotos ();
    /**
     *
     * @param candidato, referencia de la persona postulada a un cargo.
     * @return cantidad de votos hacia la persona enviada.
     */
    int contarVotos (Candidato candidato);
    /**
     *
     * @param listaPolitica, lista politica de la cual se quiere saber los votos que obtuvo.
     * @return la cantidad de votos que recibió la lista.
     */
    int contarVotos (ListaPolitica listaPolitica);
}
