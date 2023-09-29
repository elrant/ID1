#!/bin/bash

# (c) Team Elrant - irisnk

usage() {
  echo "Usage: $0 [-c | -s | -r]"
  echo "  -c  Copy hook templates to .git/hooks (default)"
  echo "  -s  Set local Git config to change hooks directory to .githooks"
  echo "  -r  Revert to the default Git hooks path"
  exit 1
}

# By default, copy the hook templates
action="copy"

while getopts ":csr" opt; do
  case $opt in
    c) action="copy" ;;
    s) action="set" ;;
    r) action="revert" ;;
    \?) echo "Invalid option: -$OPTARG" >&2
        usage ;;
  esac
done

if [ "$action" == "copy" ]; then
  # Copy hook templates from the repository to the local .git/hooks directory
  cp .githooks/* .git/hooks/

  # Make sure the copied hooks are executable
  chmod +x .git/hooks/*
  
  echo "Git hooks have been copied to .git/hooks. You're all set!"
elif [ "$action" == "set" ]; then
  # Set local Git config to change hooks directory to .githooks
  git config core.hooksPath .githooks
  
  echo "Git hooks directory has been set to .githooks in local config. You're all set!"
elif [ "$action" == "revert" ]; then
  # Revert to the default Git hooks path
  git config --unset core.hooksPath
  
  echo "Git hooks directory has been reverted to the default path. You're all set!"
fi
