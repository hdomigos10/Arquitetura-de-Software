# Análise de Estilos Arquiteturais

Estilos escolhidos: **Cliente-Servidor** e **Publicador/Assinante**.

---

## 1. Cliente-Servidor

### Conceito e definição
O estilo cliente-servidor divide o sistema em dois papéis bem definidos: o **servidor**, que concentra os dados e a lógica de negócio e fica escutando requisições, e o **cliente**, que solicita serviços ou recursos ao servidor. A comunicação é tipicamente síncrona e segue o modelo requisição-resposta: o cliente envia uma requisição, o servidor processa e devolve o resultado. Um mesmo servidor pode atender vários clientes simultaneamente, e um cliente pode, eventualmente, consumir mais de um servidor.

### Casos de uso comuns
- **Aplicações web tradicionais**: o navegador (cliente) faz requisições HTTP a um servidor de aplicação, que consulta o banco de dados e devolve HTML/JSON. Praticamente todo site ou API REST segue esse modelo.
- **Sistemas de e-mail (protocolo IMAP/SMTP)**: clientes de e-mail (Outlook, apps de celular) se conectam a servidores de e-mail para enviar, buscar e sincronizar mensagens.
- **Bancos de dados corporativos**: aplicações desktop ou web (clientes) se conectam a um SGBD como MySQL ou PostgreSQL (servidor) para executar consultas.

### Principais vantagens
- **Centralização dos dados e da lógica**, o que facilita manutenção, backup e aplicação de regras de negócio em um único lugar.
- **Segurança mais fácil de controlar**, já que o acesso a dados sensíveis passa por um ponto único (o servidor).
- **Escalabilidade vertical simples**: é possível melhorar o hardware do servidor ou adicionar réplicas para atender mais clientes.
- **Reuso**: o mesmo servidor pode atender múltiplos tipos de cliente (web, mobile, desktop).

### Principais desvantagens
- **Ponto único de falha**: se o servidor cair, todos os clientes ficam sem serviço.
- **Gargalo de desempenho**: quando o número de clientes cresce muito, o servidor pode não suportar a carga sem investimento em escalabilidade (balanceadores, réplicas, cache).
- **Acoplamento à disponibilidade de rede**: sem conexão com o servidor, o cliente geralmente não funciona, a menos que haja suporte a modo offline.
- **Custo de infraestrutura** concentrado no servidor, que precisa ser dimensionado para o pico de uso.

---

## 2. Publicador/Assinante (Publish/Subscribe)

### Conceito e definição
No estilo publicador/assinante, os componentes não se comunicam diretamente entre si. Em vez disso, **publicadores** enviam mensagens/eventos para um **canal (tópico)** intermediado por um *message broker*, e **assinantes** interessados naquele tópico recebem as mensagens automaticamente. Publicador e assinante não precisam conhecer um ao outro — a comunicação é assíncrona e desacoplada no tempo e no espaço, permitindo que múltiplos assinantes reajam ao mesmo evento de formas diferentes.

### Casos de uso comuns
- **Sistemas de notificação em tempo real**: um evento como "pedido criado" é publicado e vários serviços (e-mail, estoque, financeiro) reagem de forma independente, cada um assinando o tópico que lhe interessa.
- **Processamento de dados em larga escala com Kafka**: empresas como Netflix e Uber usam Apache Kafka para processar eventos de milhões de usuários (cliques, corridas, streams) de forma desacoplada entre produtores e consumidores.
- **Aplicações de chat e IoT**: serviços como MQTT (usado em dispositivos IoT) ou o Pub/Sub do Google Cloud distribuem mensagens de sensores para múltiplos consumidores em tempo real.

### Principais vantagens
- **Baixo acoplamento**: publicadores e assinantes não precisam se conhecer, o que facilita adicionar ou remover componentes sem afetar os demais.
- **Escalabilidade horizontal**: é fácil adicionar novos assinantes para reagir ao mesmo evento sem mudar o publicador.
- **Assincronismo**: o publicador não fica bloqueado esperando os assinantes processarem a mensagem, o que melhora a responsividade do sistema.
- **Flexibilidade para arquiteturas orientadas a eventos**, favorecendo sistemas distribuídos e reativos.

### Principais desvantagens
- **Complexidade de depuração**: como o fluxo é assíncrono e indireto, é mais difícil rastrear o caminho de uma mensagem e diagnosticar falhas.
- **Consistência eventual**: como as atualizações não são imediatas para todos os assinantes, o sistema pode, por um curto período, ficar com dados desatualizados em partes diferentes.
- **Dependência do broker**: a solução introduz um novo componente de infraestrutura (o message broker), que precisa ser mantido, monitorado e pode se tornar ele mesmo um ponto de gargalo ou falha.
- **Garantias de entrega**: garantir que uma mensagem foi entregue e processada corretamente (evitando duplicidade ou perda) exige mecanismos adicionais (acknowledgements, filas de retry, idempotência).
