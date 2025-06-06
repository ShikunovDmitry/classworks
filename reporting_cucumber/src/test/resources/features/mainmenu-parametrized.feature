# language: ru

Функция: Главное меню

  @auto @issue=123456 @Tms=2223366
  Сценарий: Проверка подменю для Автобарахолки
    Дано открыт сайт onliner.by
#    Когда наведен курсор на пункт AUTO enum
    Когда наведен курсор на пункт "Автобарахолка"
#    Тогда появляется подменю с категориями, разграниченным по ценам ,по городам, и по маркам
    Тогда появляется подменю с категориями
      | Новые авто        |
      | С пробегом        |
      | Цена с НДС        |
      | Авто до 4000 р.   |
      | Авто до 10 000 р. |
      | Авто до 20 000 р. |
    И появляется подменю с категориями
      | Минск   |
      | Гомель  |
      | Могилев |
      | Витебск |
      | Гродно  |
      | Брест   |
    И появляется подменю с категориями
      | Audi          |
      | BMW           |
      | Citroen       |
      | Ford          |
      | Mazda         |
      | Mercedes-Benz |
      | Nissan        |
      | Opel          |
      | Peugeot       |
      | Renault       |
      | Toyota        |
      | Volkswagen    |

  @flat @Epic=12348 @Story=55456
  Сценарий: Проверка подменю для Дома и квартиры
    Дано открыт сайт onliner.by
    Когда наведен курсор на пункт "Дома и квартиры"
#    Тогда появляется подменю с категориями, разграниченным по городам, количеством комнат, ценовым диапазоном
    Тогда появляется подменю с категориями
      | Минск       |
      | До 30 000 $ |