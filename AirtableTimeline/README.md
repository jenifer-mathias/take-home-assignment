[//]: # (Inclua um arquivo README que aborde:)
[//]: # (Quanto tempo você gastou para fazer o desafio.)
[//]: # (O que você gostou na sua implementação.)
[//]: # (O que mudaria se fosse fazer novamente.)
[//]: # (Como você tomou suas decisões de design. Por exemplo, se você se inspirou em outras timelines, mencione isso.)
[//]: # (Como você testaria seu app se tivesse mais tempo.)
[//]: # (Instruções especiais sobre como construir/rodar seu app.)

[//]: # (Melhorias:)
[//]: # (Depois de ter uma versão básica da timeline somente leitura, aqui estão algumas melhorias opcionais para você tentar:)
[//]: # (Permitir edição dos eventos.)
[//]: # (Permitir zoom in e zoom out da timeline.)
[//]: # (Permitir arrastar e soltar para alterar a data de início e/ou término dos eventos.)
[//]: # (Qualquer outro polimento ou aprimoramento útil que você pensar.)

- How long you spent on the assignment.
  I spent approximately 4 hours completing this challenge, focusing on designing a clean and maintainable timeline visualization.

- What you like about your implementation.
I enjoyed with the modular architecture following Clean Architecture principles combined with an MVI pattern, which provides clear separation of concerns and testability. The timeline arranges events in compact lanes with proportional sizing based on event duration. The UI supports zooming for better user experience. Furthermore, using this architecture is recommended to work with Compose.

- What you would change if you were going to do it again.
I would like remove data mocks and integrate with backend to leave the frontend only responsible for handling requests and showing the results to the user and to maintain grater security in the app;
I would add more tests, like instrumented tests.

- How you made your design decisions. For example, if you looked at other timelines for inspiration, please note that.
- How you would test this if you had more time.
- Any special instructions on how to build/run your app.


- I'm using Java 11 because is stablish for Jetpack Compose;
- 
- I changed Date because is deprecated in Java and I created an Utils file to instance a Calendar

compileOptions {
sourceCompatibility = JavaVersion.VERSION_11
targetCompatibility = JavaVersion.VERSION_11
}
kotlinOptions {
jvmTarget = "11"
}

- I created a navigation scheme to manage the navigation, centralizing all navigation to facilitate
  find the classes.

### DI

I choose Hilt to Dependency Injection, because this tool has official support by Google, is more
simple to setting and the performance is high, because uses code generation.

### Points for improvement

- Remove mock Events and integrate the timeline with backend data

