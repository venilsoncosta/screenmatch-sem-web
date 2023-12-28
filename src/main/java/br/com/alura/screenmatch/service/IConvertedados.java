package br.com.alura.screenmatch.service;

public interface IConvertedados {
    <T> T obterdados(String json, Class<T> classe);
}
