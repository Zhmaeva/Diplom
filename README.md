# Дипломный проект по профессии «Инженер по тестированию»
__________________________________________________________________
## Цель проекта: тестирование мобильного приложения «Мобильный хоспис»
[Ссылка на задание](https://github.com/netology-code/qamid-diplom)

### Документация:
- [план тестирования](Plan.md)
- [чек-лист](Check.xlsx)
- [тест-кейсы](Cases.xlsx)
- [отчет о тестировании](Result.md)

### Запуск приложения:
- клонировать [репозиторий](https://github.com/Zhmaeva/Diplom)
- открыть проект в Android Studio
- перейти в каталог `fmh_android_15_03_24`  

данные для авторизации:  
**Логин**: `login2`  
**Пароль**: `password2`

### Запуск тестов:  

1. установить Scope:  
   - `Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser`
   - `irm get.scoop.sh | iex`
2. установить Allure:  
   - `scoop install allure`
   - `allure --version`
3. запустить эмуляторы или реальные устройства (API 29)
4. сменить язык устройства или эмулятора на английский
4. выделить каталог app (лкм):
   - запустить тесты Shift+Ctrl+F10 (Windows) или `run All Tests`
   - запустить тесты Command+Shift+R, Command+Shift+D (Mac)
5. в `Device Explorer`, выбрать `/data/data/ru.iteco.fmhandroid/allure-results`,  
сохранить в выбранную папку.  
6. в директории с папкой `allure-results` выполнить команду в командной строке
7. В терминале ввести `allure serve` и посмотреть открывшийся отчет