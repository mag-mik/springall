https://habr.com/ru/post/444982/

1. create mock of DataService
DataService dataServiceMock = Mockito.mock(DataService.class);

2.drive behaviour 
List<String> data = new ArrayList<>();
data.add("dataItem");
Mockito.when(dataService.getAllData()).thenReturn(data);

3. send parameters to mocked methods
String getDataItemById(String id) { some code...}
Mockito.when(dataService.getDataItemById(any())) .thenReturn("dataItem");

Mockito.any - > Mockito.eq (эквивалентности) - > Mockito.same (сравнение ссылок)

Mockito.when(dataService.getDataItemById("idValue")).thenReturn("dataItem");
// or
Mockito.when(dataService.getDataItemById(Mockito.eq("idValue"))).thenReturn("dataItem");

Mockito.when(dataService.getDataById(
             Mockito.argThat(arg -> arg == null || arg.length() > 5)))
       .thenReturn("dataItem")

4.throw Exception 
Mockito.when(dataService.getDataById("invalidId"))
       .thenThrow(new IllegalArgumentException());
       
       
5. set parameters
Mockito.when(dataService.getDataByIds(Mockito.any()))
       .thenAnswer(invocation -> invocation
                .<List<String>>getArgument(0).stream()
                .map(id -> {
                    switch (id) {
                        case "a":
                            return "dataItemA";
                        case "b":
                            return "dataItemB";
                        default:
                            return null;
                    }
                })
                .collect(Collectors.toList()));
         
specific 
AnswersWithDelay, ReturnsElementsOf

6.
Mockito.when(dataService.getDataById("a"))
       .thenReturn("valueA1", "valueA2")
       .thenThrow(IllegalArgumentException.class);
первый вызов метода с заданным параметром вернёт "valueA1, второй — "valueA2 (не спрашивайте), а третий (и все последующие) будет вызывать выбрасывание IllegalArgumentException.

7. check a calls of methods

Mockito.verify(dataService).getDataById(Mockito.any());

пройдёт успешно, если она находится после единственного за время выполнения теста вызова метода getDataById, и упадёт, если метод не был вызван или был вызван дважды и более.
подсчёт идёт от самого создания mock'а, если только его не обнуляли специально 
or
Mockito.verify(dataService, Mockito.times(1))
       .getDataById(Mockito.any());

Mockito.verify(dataService, Mockito.after(1000).times(1))
       .getDataById(Mockito.any());
сперва ждёт в течение заданного в миллисекундах периода времени в расчёте на то, что эти вызовы всё же будут совершены


