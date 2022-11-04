package com.example

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.getSystemService

inline val Context.layoutInflater: LayoutInflater
  get() = getSystemService()!!
