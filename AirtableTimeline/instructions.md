# Airtable timeline assignment

## Expected implementation time:

4 hours

## High level objective:

Design and implement an app for visualizing events on a timeline.

## Details:

The timeline app will be used to display a number of events. Each event has at least 3 main pieces of information - the name,
the start date, and the end date. The events dates could overlap. The size of the event in the timeline should be
proportional to the number of days the event lasts.

The final design is up to you but your timeline app should attempt to arrange items in compact, space-efficient lanes.
If event A ends before event B starts, these events can share a lane.

The start and end dates will be formatted as `Date` objects. You don't need to worry about hours, minutes, seconds, or time zones.

You can assume every event's end date is the same or later than its start date.

Avoid using libraries that solve too much of the problem. General purpose libraries are definitely okay, but a library that
calculates the layout for a multi-lane timeline is not, for example.

## Scaffolding:

We include a basic app here to get you started. This app contains basic classes you can use to display your timeline, and it runs out of the box.
Please consider this as just a suggestion, and a way to help you get started.
If you dislike any architectural decisions, you're completely free to change and modify this code however you see fit, or even start completely fresh.

You can start writing your timeline code in the `TimelineScreen` class; it contains a TODO comment where you should display the data in swimlanes, as described above.

## Improvements:

After you have a basic read-only timeline app, here are some potential improvements to attempt as stretch goals:

- Allow edits of the events.
- Allow zooming in and out of the timeline.
- Allow dragging and dropping to change the start date and/or end date for an event.
- Any other polish or useful enhancements you can think of.

Include a README that covers:

- How long you spent on the assignment.
- What you like about your implementation.
- What you would change if you were going to do it again.
- How you made your design decisions. For example, if you looked at other timelines for inspiration, please note that.
- How you would test this if you had more time.
- Any special instructions on how to build/run your app.

What we're looking for:

- Clean, readable, maintainable code.
- A sensible user experience and design for the final product.

[PT-BR]
O app de timeline será usado para exibir diversos eventos. 
Cada evento possui pelo menos 3 informações principais — o nome, a data de início e a data de término.
As datas dos eventos podem se sobrepor. O tamanho do evento na timeline deve ser proporcional ao número de dias que o evento dura.

O design final fica a seu critério, mas seu app de timeline deve tentar organizar os itens em faixas (lanes) compactas e que economizem espaço.
Se o evento A termina antes do evento B começar, esses eventos podem compartilhar a mesma faixa.

As datas de início e término serão fornecidas como objetos do tipo Date. 
Não é necessário se preocupar com horas, minutos, segundos ou fusos horários.
Você pode assumir que a data de término de cada evento é igual ou posterior à data de início.
Evite usar bibliotecas que resolvam grande parte do problema automaticamente. 
Bibliotecas de uso geral são permitidas, mas, por exemplo, uma biblioteca que calcula automaticamente
o layout para uma timeline com múltiplas faixas não é permitida.

Estrutura inicial:
Incluímos um app básico para ajudar você a começar. Esse app contém classes básicas que você pode usar para exibir sua timeline e funciona imediatamente.
Considere isso apenas como uma sugestão e uma forma de facilitar o início do desenvolvimento.
Se você não gostar de alguma decisão arquitetural, fique à vontade para modificar ou até começar do zero.
Você pode começar a escrever o código da timeline na classe TimelineScreen; 
ela contém um comentário TODO indicando onde você deve exibir os dados nas swimlanes, conforme descrito acima.

Melhorias:
Depois de ter uma versão básica da timeline somente leitura, aqui estão algumas melhorias opcionais para você tentar:
Permitir edição dos eventos.
Permitir zoom in e zoom out da timeline.
Permitir arrastar e soltar para alterar a data de início e/ou término dos eventos.
Qualquer outro polimento ou aprimoramento útil que você pensar.

Inclua um arquivo README que aborde:
Quanto tempo você gastou para fazer o desafio.
O que você gostou na sua implementação.
O que mudaria se fosse fazer novamente.
Como você tomou suas decisões de design. Por exemplo, se você se inspirou em outras timelines, mencione isso.
Como você testaria seu app se tivesse mais tempo.
Instruções especiais sobre como construir/rodar seu app.

O que estamos buscando:
Código limpo, legível e fácil de manter.
Uma experiência e design sensatos para o usuário final.