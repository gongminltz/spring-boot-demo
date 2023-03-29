import sys
import requests

if __name__ == '__main__':
    traceId = sys.argv[1]
    callbackUrl = sys.argv[2]
    param = sys.argv[3]

    params = param.split(',')
    num1 = int(params[0])
    num2 = int(params[1])

    print("traceId = ", traceId)
    print("callbackUrl = ", callbackUrl)
    print(num1, " + ", num2, " = ", (num1 + num2))

    requests.post(url = callbackUrl,
        headers = {"Content-Type": "application/x-www-form-urlencoded"},
        data = {"result": num1 + num2}
        )

