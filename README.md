# T1_VeriVal

[![Java CI with Maven](https://github.com/GuilhermeVSam/T1_VeriVal/actions/workflows/maven.yml/badge.svg)](https://github.com/GuilhermeVSam/T1_VeriVal/actions/workflows/maven.yml)

### Este repositorio é destinado ao desenvolvimento e execução do trabalho 1 da diciplina de Verificação e Validação de Software da instituição Pontifícia Universidade Católica do Rio Grande do Sul (PUCRS).

### Integrantes: 
[Guilherme Velho](https://github.com/GuilhermeVSam) e [Pedro Araujo](https://github.com/PedroRamos02)

<br>

## Descrição

Este trabalho consiste desenvolver um codigo a partir de um dos problemas disponiveis na plataforma [Beecrowd](https://judge.beecrowd.com/pt) e aplicar técnicas de teste na solução desenvolvida.

### Técnicas aplicadas
- Partições
- Valor-limite
- Contratos
- Propriedades

<br>

## Desafio escolhido

### [O Mar não está para Peixe](https://judge.beecrowd.com/pt/problems/view/2393)
Em um arquipélago no meio do Oceano Pacífico a economia é regida pela pesca, pois o peixe é o principal alimento disponível. Ultimamente, a população desse arquipélago tem aumentado drasticamente, o que levou a um grande aumento da pesca, e, consequentemente, a problemas.

Neste arquipélago, cada pescador vai diariamente ao alto mar com a intenção de conseguir trazer o maior número de peixes para o seu vilarejo. Com a expansão da pesca, os pescadores estão começando a jogar suas redes de pesca por cima das de outros pescadores. Com isso, os pescadores perdem, pois apenas o primeiro pescador pega os peixes da intersecção entre as redes.

A Associação dos Pescadores da ilha decidiu fazer um levantamento para descobrir quanto do mar está de fato sendo aproveitado, ou seja, qual a área do mar que está coberta por pelo menos uma rede de pesca.

Como há muitas intersecções entre as redes de pesca, é muito difícil para a associação calcular a área total da região coberta pelas redes. Por este motivo, eles pediram para que você escrevesse um programa para resolver este problema.

Como é muito difícil navegar pelo mar, os pescadores sempre jogam as redes de forma que as regiões cobertas por cada rede são sempre retângulos com lados paralelos aos eixos, se imaginarmos o mar como um plano cartesiano.

### Entrada:
A primeira linha da entrada possui um inteiro N (1 ≤ N ≤ 100)indicando o número de redes que foram lançadas. As próximas N linhas descrevem as regiões cobertas pelas redes: cada uma contém quatro inteiros Xi e Xf , Yi e Yf  (1 ≤ Xi ≤ Xf ≤100) e (1 ≤ Yi ≤ Yf ≤ 100). A região coberta pela rede em questão contém todo ponto (X,Y) tal que Xi ≤ X ≤ Xf e Yi ≤ Y ≤ Yf.

### Saída:
A saída deve conter apenas uma linha contendo a área da região do mar realmente aproveitada pelos pescadores, ou seja, a área total da região do mar coberta por pelo menos uma rede de pesca.

| Exemplo de Entrada                       | Exemplo de Saída |
|------------------------------------------|------------------|
| 2 <br> 1 3 1 3 <br> 2 4 2 4              | 7                |
| 3 <br> 1 6 1 2 <br> 3 7 1 2 <br> 2 5 1 2 | 6                |

<br>

## Ferramentas e tecnologias utilizadas
Java 21  
JUnit 5.12.2  
JQwik 1.9.2

### Como executar testes:
Execute no terminal os seguintes comandos:
```
$ sdk install java 21.0.7-amzn
$ cd verival
$ mvn clean compile
$ mvn test
```

### [Documentação de desenvolvimento do algoritmo e testes](https://github.com/GuilhermeVSam/T1_VeriVal/issues)
