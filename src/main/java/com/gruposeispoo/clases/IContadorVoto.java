package com.gruposeispoo.clases;

public interface IContadorVoto {
    /**
     * Cuenta la cantidad de votos en blanco.
     * @return cantidad de votos en blancos totales.
     */
    int contarVotosBlanco();
    /**
     * Cuenta la cantidad de votos en blanco del tipo de candidato que se le pase.
     * @param tipoCandidato, El tipo de candidato que es (senador o diputado).
     * @return devuelve la cantidad de votos en blanco de este tipo de candidato.
     */
    int contarVotosBlanco (TipoCandidato tipoCandidato);

    /**
     * Cuenta los votos totales.
     * @return cantidad de votos generales.
     */
    int contarVotos ();
    /**
     * Cuenta los votos de este candidato.
     * @param candidato, referencia de la persona postulada a un cargo.
     * @return cantidad de votos hacia la persona enviada.
     */
    int contarVotos (Candidato candidato);
    /**
     * Cuenta los votos de esta lista politica.
     * @param listaPolitica, lista politica de la cual se quiere saber los votos que obtuvo.
     * @return la cantidad de votos que recibió la lista.
     */
    int contarVotos (ListaPolitica listaPolitica);
}
