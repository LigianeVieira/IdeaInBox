package com.IdeaBox.controllers;

import com.IdeaBox.models.sugestoes.Sugestao;

public class main {
	public static void main(String[] args) {
		Sugestao sugestao = new Sugestao(null, null, null, "Ola");
		System.out.println(sugestao.getDataEnvio());
	}
}
