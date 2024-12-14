# Conversor de Moedas com ExchangeRate-API

Este é um projeto em Java que utiliza a **ExchangeRate-API** para realizar conversões entre diferentes moedas. O programa permite que o usuário informe a moeda de origem, a moeda de destino e o valor a ser convertido. A aplicação funciona em um loop, permitindo múltiplas conversões até que o usuário decida encerrar.

## Funcionalidades

- Conversão de valores entre moedas usando taxas de câmbio atualizadas.
- Suporte a diversas moedas disponíveis na ExchangeRate-API.
- Interface de texto simples e interativa.
- Loop contínuo para múltiplas conversões (encerra ao digitar `0` como valor).

## Tecnologias Utilizadas

- **Java 11** ou superior.
- **HttpClient** para comunicação com a API.
- **Gson** para manipulação de JSON.
- **ExchangeRate-API** para obter as taxas de câmbio.

## Como Usar

1. Clone este repositório para sua máquina local.
2. Substitua a variável `API_KEY` no código com a sua chave de API da ExchangeRate-API.
3. Compile e execute o programa:
   ```bash
   javac Main.java
   java Main
