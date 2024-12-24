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
3. 