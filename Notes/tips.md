# Use a set to check res for duplicate characters
```python
if len(res) != len(set(res)):
            return 0
```
- we can check if a string has duplicate characters by creating a set version of it using `set()` and passing the string in as an argument
