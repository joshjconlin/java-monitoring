#!/usr/bin/env bash
docker run -p 8080:8080 -p 7777:7777 --name monitoring -t bitesquad/monitoring:latest
