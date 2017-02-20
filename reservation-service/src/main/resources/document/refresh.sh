#!/usr/bin/env bash
curl --cookie-jar cookie -L http://localhost:8000/message | grep csrf
curl --cookie cookie -d "username=user&password=password&_csrf=d5c34c7d-50d1-458c-96ef-524bcf78ff87" -L http://localhost:8000/message