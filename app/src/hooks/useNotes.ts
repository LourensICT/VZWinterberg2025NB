import { useEffect, useState } from 'react'
import type { Note } from '../types'
import { db } from '../db'

export function useNotes() {
  const [notes, setNotes] = useState<Note[]>([])
  const [loading, setLoading] = useState(true)

  async function reload() {
    const all = await db.notes.orderBy('createdAt').reverse().toArray()
    setNotes(all)
  }

  useEffect(() => {
    reload().finally(() => setLoading(false))
  }, [])

  return { notes, loading, reload }
}