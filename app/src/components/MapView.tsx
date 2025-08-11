import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import 'leaflet/dist/leaflet.css'
import type { LocationNote } from '../types'
import L, { latLngBounds, type LatLngTuple } from 'leaflet'
import iconUrl from 'leaflet/dist/images/marker-icon.png'
import iconRetinaUrl from 'leaflet/dist/images/marker-icon-2x.png'
import shadowUrl from 'leaflet/dist/images/marker-shadow.png'

L.Icon.Default.mergeOptions({
  iconUrl,
  iconRetinaUrl,
  shadowUrl,
})

export default function MapView({ locations }: { locations: LocationNote[] }) {
  const center: LatLngTuple = locations.length
    ? [locations[0].latitude, locations[0].longitude]
    : [51.505, -0.09]

  const points: LatLngTuple[] = locations.map((l) => [l.latitude, l.longitude])
  const bounds = points.length ? latLngBounds(points) : undefined

  return (
    <div className="w-full h-[60vh] rounded-xl overflow-hidden border border-neutral-200/70 dark:border-neutral-800/70">
      <MapContainer center={center} zoom={13} style={{ height: '100%', width: '100%' }} bounds={bounds}>
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {locations.map((l) => (
          <Marker key={l.id} position={[l.latitude, l.longitude]}>
            <Popup>
              <div className="text-sm">
                <div className="font-medium">{l.name}</div>
                <div className="text-neutral-600">{l.latitude.toFixed(5)}, {l.longitude.toFixed(5)}</div>
              </div>
            </Popup>
          </Marker>
        ))}
      </MapContainer>
    </div>
  )
}