# Проект по автоматизации тестовых сценариев для сайта компании  <a href="https://level.travel/ "> LevelTravel</a></h1>

<img alt="GIPHY" src="media/lvt.png">


Написаны тесты на проверку доступного функционала

Негативный тест на поиск тура без выбора даты

Динамический тест на поиск тура по рандомным значениям (библиотека Faker)

## Содержание:

- Используемый стек
- Запуск автотестов
- Сборка в Jenkins
- Пример Allure-отчета
- Интеграция с Allure TestOps
- Интеграция с Jira
- Уведомления в Telegram
- Видео примера запуска тестов в Selenoid

## Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="/media/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/Java.svg">
<img width="6%" title="Selenide" src="media/Selenide.svg">
<img width="6%" title="Selenoid" src="media/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/Gradle.svg">
<img width="6%" title="JUnit5" src="media/JUnit5.svg">
<img width="6%" title="GitHub" src="media/GitHub.svg">
<img width="6%" title="Jenkins" src="media/Jenkins.svg">
<img width="6%" title="Telegram" src="media/Telegram.svg">
<img width="5%" title="Jira" src="media/Jira.svg">
</p>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для
тестирования [Selenide](https://selenide.org/), сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в
качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов
в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>
Jira</code>.

Содержание Allure-отчета:

* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## Запуск автотестов

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="/media/Jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/JenkinsScreen.png">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

**Для локального запуска используется команда:**

./gradlew clean Test


[Ссылка на JenkinsJob](https://jenkins.autotests.cloud/job/ui_diploma_irinamolodtsova/)

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="/media/Allure_Report.svg"> Пример Allure-отчета

### Overview

<p align="center">
<img title="Allure Overview" src="media/AllurereportScreen.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="/media/AllureTestOps.svg"> Интеграция с Allure TestOps

На *Dashboard* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся
вручную, сколько автоматизированы. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске
сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/allureDash.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Test Results in Alure TestOps" src="media/allureOPScren.png">
<img title="Cases Results in Alure TestOps" src="media/resultCasesScreen.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="/media/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были
написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jiraScreen.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="/media/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет
сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/telegramscreen.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="/media/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/v.gif">
</p>